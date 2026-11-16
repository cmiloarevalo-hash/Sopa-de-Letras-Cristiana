import XCTest

/// Smoke tests executed on an actual iOS Simulator in the macOS GitHub runner.
/// These exercise the running app, not just compilation or JSON inspection.
final class IPhoneExperienceSmokeTests: XCTestCase {
    override func setUpWithError() throws {
        continueAfterFailure = false
    }

    private func launch() -> XCUIApplication {
        let app = XCUIApplication()
        app.launchArguments += ["-AppleLanguages", "(es)", "-AppleLocale", "es_CL"]
        app.launch()
        return app
    }

    private func openHomeAction(_ title: String, app: XCUIApplication) {
        let link = app.buttons.matching(
            NSPredicate(format: "label CONTAINS[c] %@", title)
        ).firstMatch
        XCTAssertTrue(link.waitForExistence(timeout: 20), "No se encontró la opción \(title)")
        link.tap()
    }

    private func capture(_ name: String) {
        let attachment = XCTAttachment(screenshot: XCUIScreen.main.screenshot())
        attachment.name = name
        attachment.lifetime = .keepAlways
        add(attachment)
    }

    func testHomeRendersRealCatalogAndCampaign() {
        let app = launch()
        XCTAssertTrue(
            app.staticTexts["Sopa de letras"].waitForExistence(timeout: 20),
            "La aplicación no abrió el inicio"
        )
        XCTAssertTrue(
            app.staticTexts["300 niveles · 10 mundos"].exists,
            "No cargó el catálogo de Android compartido"
        )
        capture("01-inicio-iphone")
        openHomeAction("Campaña bíblica", app: app)
        XCTAssertTrue(
            app.staticTexts["Los 10 mundos"].waitForExistence(timeout: 12) ||
            app.navigationBars["Los 10 mundos"].exists,
            "No abrió los diez mundos"
        )
        capture("02-mundos-iphone")
    }

    func testMystery8x8RespectsUserSelection() {
        let app = launch()
        openHomeAction("Palabra misteriosa", app: app)
        let selected = app.buttons["8×8"]
        XCTAssertTrue(selected.waitForExistence(timeout: 15), "Falta tamaño 8×8")
        selected.tap()
        let world = app.buttons.matching(
            NSPredicate(format: "label CONTAINS[c] %@", "La creación y la vida")
        ).firstMatch
        XCTAssertTrue(world.waitForExistence(timeout: 15), "No hay opción de misterio para el primer mundo")
        world.tap()
        XCTAssertTrue(
            app.staticTexts["8×8 · 6 palabras"].waitForExistence(timeout: 25),
            "Error: el misterio cambia de tamaño o no genera el tablero"
        )
        capture("03-misterio-8x8-iphone")
    }

    func testOfflineBibleGensis1AndDeveloperCredits() {
        let app = launch()
        openHomeAction("Leer la Biblia", app: app)
        let genesis = app.buttons.matching(
            NSPredicate(format: "label CONTAINS[c] %@", "Génesis")
        ).firstMatch
        XCTAssertTrue(genesis.waitForExistence(timeout: 15), "No se cargaron los 66 libros")
        genesis.tap()
        let firstChapter = app.buttons["1"]
        XCTAssertTrue(firstChapter.waitForExistence(timeout: 15))
        firstChapter.tap()
        let verse = app.staticTexts.matching(
            NSPredicate(format: "label CONTAINS[c] %@", "Sea la luz")
        ).firstMatch
        XCTAssertTrue(verse.waitForExistence(timeout: 20), "No se ve Génesis 1:3 desde datos offline")
        capture("04-biblia-genesis-1-iphone")
    }

    func testDeveloperContactIsVisible() {
        let app = launch()
        openHomeAction("Acerca de esta aplicación", app: app)
        XCTAssertTrue(app.staticTexts["Camilo Arévalo"].waitForExistence(timeout: 12))
        XCTAssertTrue(app.links["apkcristiana@gmail.com"].exists ||
                      app.staticTexts["apkcristiana@gmail.com"].exists)
        XCTAssertTrue(app.staticTexts["Guía pastoral - Biblia"].exists)
        capture("05-desarrollador-iphone")
    }
}
