package app.sopadeletras.sync

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class ProgressMergeTest {
    @Test fun neverLosesStarsAndPreservesWinningTime() {
        val local = ProgressBackup(levels = mapOf(1 to LevelBackup(3, 120), 2 to LevelBackup(1, 20)))
        val remote = ProgressBackup(levels = mapOf(1 to LevelBackup(2, 60), 2 to LevelBackup(3, 95)))
        val result = ProgressMerge.combine(local, remote)
        assertEquals(LevelBackup(3, 120), result.levels[1])
        assertEquals(LevelBackup(3, 95), result.levels[2])
    }

    @Test fun picksFastestTimeOnlyForEqualStars() {
        val local = ProgressBackup(levels = mapOf(1 to LevelBackup(3, 90)))
        val remote = ProgressBackup(levels = mapOf(1 to LevelBackup(3, 45)))
        assertEquals(LevelBackup(3, 45), ProgressMerge.combine(local, remote).levels[1])
    }

    @Test fun mergesSeparateLevelsWithoutLosingLocalNickname() {
        val local = ProgressBackup(nickname = "Exploradora", levels = mapOf(1 to LevelBackup(2, 80)))
        val remote = ProgressBackup(nickname = "Otro apodo", levels = mapOf(300 to LevelBackup(3, 230)))
        val result = ProgressMerge.combine(local, remote)
        assertEquals(setOf(1, 300), result.levels.keys)
        assertEquals("Exploradora", result.nickname)
    }

    @Test fun rejectsInvalidBackupBeforeSync() {
        assertThrows(IllegalArgumentException::class.java) {
            ProgressBackup(levels = mapOf(301 to LevelBackup(2, 10)))
        }
        assertThrows(IllegalArgumentException::class.java) {
            LevelBackup(4, 10)
        }
    }
}
