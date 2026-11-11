# Sopa de Letras Cristiana — Palabras exactas de los 300 niveles
**Catálogo educativo V1 · 11 de noviembre de 2026**
**Fuente de ejecución estructurada:** [campana_300_niveles_v1.json](data/campana_300_niveles_v1.json) · **Guía integral de producto:** [Especificación maestra](ESPECIFICACION_MAESTRA_APK_CRISTIANA_V1.md).

**Estado verificable:** 300 niveles definidos; 2.545 apariciones planificadas de palabras normales y diez misterios con sus soluciones/pistas. Revisión de longitud, duplicados y conflictos de substring completada. Simulación independiente de disposición de cuadrículas: **300 de 300 posibles**, con conteo correcto de palíndromos. **NO está implementado todavía en la APK ni validado por sus pruebas Kotlin y Android.**

## Qué significa este catálogo para quien juega

El niño o joven verá una historia bíblica sencilla, una sopa de letras que puede resolver sin conocimientos religiosos previos y, al completar el nivel, un mensaje positivo asociado al episodio. **Las palabras de cada nivel están definidas aquí, no dependen de que el programa elija un subconjunto arbitrario de un banco de 70.** Los nombres y valores ayudan a conocer la vida de Jesús, el Antiguo y Nuevo Testamento y a practicar amor, esperanza, paz, amistad, respeto y solidaridad.

Se mantiene un recorrido de tres episodios de diez niveles por mundo. Cada episodio tiene un pasaje de referencia de Reina-Valera 1909; el mensaje es una **explicación original y actual**, nunca una cita textual ficticia de Jesús.

## Tamaño real y cantidad de palabras

| Mundo | Nombre | Tablero | Palabras normales por nivel | Palabra oculta |
|---:|---|---|---:|---|
| 1 | La creación y la vida | 6×6 | 3–5 | CUIDAR |
| 2 | Las primeras familias | 8×8 | 4–7 | PERDON |
| 3 | Noé y la esperanza | 8×8 | 5–8 | PACTO |
| 4 | Abraham y las promesas | 10×10 | 6–9 | PERDON |
| 5 | Moisés, libertad y justicia | 10×10 | 7–10 | JUSTICIA |
| 6 | Jesús y su familia | 10×10 | 8–11 | ALEGRIA |
| 7 | Jesús nos enseña a amar | 12×12 | 9–12 | BONDAD |
| 8 | Jesús y sus amigos | 12×12 | 10–13 | AMISTAD |
| 9 | Jesús vive: amor y esperanza | 12×12 | 11–14 | CONSUELO |
| 10 | Una comunidad que comparte | 12×12 | 12–15 | AYUDA |

- **Tableros 6×6:** únicamente palabras de 3 a 6 letras; 3–5 por partida. **8×8:** longitud máxima de ocho, 4–8. **10×10:** máximo diez, 6–11. **12×12:** máximo doce, 9–15.
- No hay palabras duplicadas dentro de una partida. No coinciden palabras contenidas unas dentro de otras en el mismo tablero (por ejemplo, AVE/AVES, COMUNIDAD/UNIDAD). No hay una palabra normal que descubra accidentalmente la respuesta del misterio por contenerla.
- Repetir una palabra entre partidas o mundos **sí está permitido cuando refuerza su significado**; los niños pueden reencontrarse con AMOR, VIDA, CUIDADO y PAZ en distintas historias. Se limitaron repeticiones excesivas consecutivas.
- Los retos de nivel 10 son contrarreloj, los de nivel 20 incluyen **una** palabra misteriosa adicional, y los de nivel 30 cierran el mundo. No existen quince retos misteriosos por mundo.
- **Atención al programador:** `ANA`, `ALA` y `OSO` son palíndromos: el conteo heredado trata dos direcciones de la misma trayectoria como dos ocurrencias. Debe contar una única trayectoria no dirigida para permitir esas palabras válidas, en especial ANA, personaje del Evangelio. Esto es un defecto técnico corregible, no motivo para reemplazar nombres bíblicos.

## Catálogo completo

### Mundo 1 — La creación y la vida

**Episodio 1: La luz y el cielo (niveles 1–10).** Biblia: Génesis 1:1–8. Valor: Cuidado. Mensaje editorial sugerido: «La luz nos invita a descubrir la belleza de la creación.»

**Episodio 2: La tierra y las plantas (niveles 11–20).** Biblia: Génesis 1:9–19. Valor: Gratitud. Mensaje editorial sugerido: «Cuidar las plantas y el agua es valorar la vida.»

**Episodio 3: Los animales y el descanso (niveles 21–30).** Biblia: Génesis 1:20–2:3. Valor: Vida. Mensaje editorial sugerido: «La vida de personas y animales merece cuidado.»

**Reto misterioso del nivel 20:** CUIDAR. Pista: «Acción que realizamos cuando protegemos la naturaleza y respetamos la vida.».

| Nivel | Episodio | Tipo | Palabras exactas que buscará el jugador |
|---:|:---:|---|---|
| 1 | 1 | Normal | LUZ, DIOS, AGUA |
| 2 | 1 | Normal | CIELO, TIERRA, DIA |
| 3 | 1 | Normal | NOCHE, AIRE, AZUL |
| 4 | 1 | Normal | CLARO, VIDA, SOL |
| 5 | 1 | Normal | LUNA, LUCES, MAR |
| 6 | 1 | Normal | NUBES, BRISA, DIA |
| 7 | 1 | Normal | ARCO, AGUAS, INICIO |
| 8 | 1 | Normal | RAYOS, CUIDAR, ORDEN |
| 9 | 1 | Normal | PAZ, LUZ, DIOS |
| 10 | 1 | Contrarreloj | AGUA, CIELO, TIERRA |
| 11 | 2 | Normal | PLANTA, FLOR, HOJA |
| 12 | 2 | Normal | RAIZ, RAMA, FRUTO |
| 13 | 2 | Normal | BROTE, ARBOL, TRIGO |
| 14 | 2 | Normal | PASTO, CAMPO, TIERRA |
| 15 | 2 | Normal | MONTES, LLANO, VALLE |
| 16 | 2 | Normal | AGUA, RIO, ROCAS, SOL |
| 17 | 2 | Normal | LLUVIA, VERDE, VIDA, CUIDA |
| 18 | 2 | Normal | CUIDAR, BELLO, BIEN, MAIZ |
| 19 | 2 | Normal | GRANOS, ROCA, PLANTA, FLOR |
| 20 | 2 | **Misterio: CUIDAR** | HOJA, RAIZ, RAMA, FRUTO |
| 21 | 3 | Normal | AVES, PEZ, PECES, OSO |
| 22 | 3 | Normal | ALAS, NIDO, PATO, AVE |
| 23 | 3 | Normal | GATO, PERRO, OVEJA, OSO |
| 24 | 3 | Normal | VACA, HUMANO, HOMBRE, MUJER |
| 25 | 3 | Normal | VIVIR, VIDA, AMOR, CUIDAR |
| 26 | 3 | Normal | PAZ, JUGAR, ALEGRE, HOGAR |
| 27 | 3 | Normal | CALMA, REPOSO, DIOS, OBRA |
| 28 | 3 | Normal | AVES, PEZ, PECES, OSO |
| 29 | 3 | Normal | ALAS, NIDO, PATO, AVE |
| 30 | 3 | **Final de mundo** | GATO, PERRO, OVEJA, OSO, VACA |

### Mundo 2 — Las primeras familias

**Episodio 1: El jardín y la familia (niveles 31–40).** Biblia: Génesis 2:4–25. Valor: Familia. Mensaje editorial sugerido: «Una familia se construye con cariño y atención.»

**Episodio 2: Nuestras decisiones (niveles 41–50).** Biblia: Génesis 3:1–24. Valor: Responsabilidad. Mensaje editorial sugerido: «Nuestras decisiones tienen consecuencias; siempre podemos aprender.»

**Episodio 3: Hermanos y generaciones (niveles 51–60).** Biblia: Génesis 4:1–5:32. Valor: Respeto. Mensaje editorial sugerido: «Hablar con respeto ayuda a cuidar nuestros vínculos.»

**Reto misterioso del nivel 50:** PERDON. Pista: «Un paso que podemos dar después de reconocer que lastimamos a alguien.».

| Nivel | Episodio | Tipo | Palabras exactas que buscará el jugador |
|---:|:---:|---|---|
| 31 | 1 | Normal | JARDIN, EDEN, ARBOL, VIDA |
| 32 | 1 | Normal | AGUA, TIERRA, PERSONA, ADAN |
| 33 | 1 | Normal | EVA, HOGAR, FAMILIA, AMOR |
| 34 | 1 | Normal | CUIDADO, ELEGIR, CUIDAR, HUERTO |
| 35 | 1 | Normal | PLANTAS, VERDAD, AYUDA, HOMBRE |
| 36 | 1 | Normal | MUJER, CAMINO, RESPETO, FRUTO |
| 37 | 1 | Normal | LIBRE, JARDIN, EDEN, ARBOL |
| 38 | 1 | Normal | VIDA, AGUA, TIERRA, PERSONA |
| 39 | 1 | Normal | ADAN, EVA, HOGAR, FAMILIA, AMOR |
| 40 | 1 | Contrarreloj | CUIDADO, ELEGIR, CUIDAR, HUERTO, PLANTAS |
| 41 | 2 | Normal | ADAN, EVA, JARDIN, FRUTO, CAMINO |
| 42 | 2 | Normal | ELEGIR, VERDAD, AYUDA, RESPETO, DIALOGO |
| 43 | 2 | Normal | AMOR, CUIDADO, HABLAR, SENTIR, ESCUCHA |
| 44 | 2 | Normal | SINCERO, DECIDIR, CAMBIO, VALOR, CASA |
| 45 | 2 | Normal | JUNTO, TRATO, BONDAD, APRENDER, ADAN |
| 46 | 2 | Normal | EVA, JARDIN, FRUTO, CAMINO, ELEGIR |
| 47 | 2 | Normal | VERDAD, AYUDA, RESPETO, DIALOGO, AMOR |
| 48 | 2 | Normal | CUIDADO, HABLAR, SENTIR, ESCUCHA, SINCERO |
| 49 | 2 | Normal | DECIDIR, CAMBIO, VALOR, CASA, JUNTO |
| 50 | 2 | **Misterio: PERDON** | TRATO, BONDAD, APRENDER, ADAN, EVA |
| 51 | 3 | Normal | CAIN, ABEL, SET, ENOC, HIJOS |
| 52 | 3 | Normal | PADRES, MADRES, FAMILIA, HISTORIA, ABUELOS |
| 53 | 3 | Normal | HOGAR, TRABAJO, CAMPO, TIERRA, CUIDADO, AMISTAD |
| 54 | 3 | Normal | CONVIVIR, APOYAR, DAR, APRENDER, ESCUCHAR, GRATITUD |
| 55 | 3 | Normal | RESPETO, ESPERAR, JUNTOS, UNIDOS, PERDON, CAIN |
| 56 | 3 | Normal | ABEL, SET, ENOC, HIJOS, PADRES, MADRES |
| 57 | 3 | Normal | FAMILIA, HISTORIA, ABUELOS, HOGAR, TRABAJO, CAMPO |
| 58 | 3 | Normal | TIERRA, CUIDADO, AMISTAD, CONVIVIR, APOYAR, DAR |
| 59 | 3 | Normal | APRENDER, ESCUCHAR, GRATITUD, RESPETO, ESPERAR, JUNTOS |
| 60 | 3 | **Final de mundo** | UNIDOS, PERDON, CAIN, ABEL, SET, ENOC, HIJOS |

### Mundo 3 — Noé y la esperanza

**Episodio 1: Preparar el arca (niveles 61–70).** Biblia: Génesis 6:9–22. Valor: Cuidado. Mensaje editorial sugerido: «Preparar y cuidar son acciones que muestran responsabilidad.»

**Episodio 2: La lluvia y el cuidado (niveles 71–80).** Biblia: Génesis 7:1–8:14. Valor: Confianza. Mensaje editorial sugerido: «En momentos difíciles, acompañarnos importa.»

**Episodio 3: Una señal de esperanza (niveles 81–90).** Biblia: Génesis 8:15–9:17. Valor: Esperanza. Mensaje editorial sugerido: «El arcoíris recuerda la señal del pacto en el relato de Noé.»

**Reto misterioso del nivel 80:** PACTO. Pista: «Compromiso que el relato de Noé relaciona con el arcoíris.».

| Nivel | Episodio | Tipo | Palabras exactas que buscará el jugador |
|---:|:---:|---|---|
| 61 | 1 | Normal | NOE, ARCA, MADERA, PUERTA, VENTANA |
| 62 | 1 | Normal | FAMILIA, ANIMALES, AVES, VIDA, BARCO |
| 63 | 1 | Normal | PAREJA, JUNTOS, CUIDADO, PREPARAR, AYUDA |
| 64 | 1 | Normal | TRABAJO, UNIDOS, BARCO, TABLAS, HOGAR |
| 65 | 1 | Normal | GUARDAR, CONFIAR, PROTEGER, VIDA, REFUGIO |
| 66 | 1 | Normal | NOE, ARCA, MADERA, PUERTA, VENTANA |
| 67 | 1 | Normal | FAMILIA, ANIMALES, AVES, VIDA, BARCO |
| 68 | 1 | Normal | PAREJA, JUNTOS, CUIDADO, PREPARAR, AYUDA |
| 69 | 1 | Normal | TRABAJO, UNIDOS, BARCO, TABLAS, HOGAR, GUARDAR |
| 70 | 1 | Contrarreloj | CONFIAR, PROTEGER, VIDA, REFUGIO, NOE, ARCA |
| 71 | 2 | Normal | AGUA, LLUVIA, NUBES, CIELO, TIERRA, MAR |
| 72 | 2 | Normal | OLAS, VIENTO, ESPERAR, CALMA, CONFIAR, FAMILIA |
| 73 | 2 | Normal | CUIDADO, ANIMALES, JUNTOS, AVES, BARCO, ARCA |
| 74 | 2 | Normal | MONTE, PUERTA, REFUGIO, LUZ, CAMINO, TIEMPO |
| 75 | 2 | Normal | AGUA, LLUVIA, NUBES, CIELO, TIERRA, MAR |
| 76 | 2 | Normal | OLAS, VIENTO, ESPERAR, CALMA, CONFIAR, FAMILIA |
| 77 | 2 | Normal | CUIDADO, ANIMALES, JUNTOS, AVES, BARCO, ARCA |
| 78 | 2 | Normal | MONTE, PUERTA, REFUGIO, LUZ, CAMINO, TIEMPO |
| 79 | 2 | Normal | AGUA, LLUVIA, NUBES, CIELO, TIERRA, MAR |
| 80 | 2 | **Misterio: PACTO** | OLAS, VIENTO, ESPERAR, CALMA, CONFIAR, FAMILIA |
| 81 | 3 | Normal | ARCOIRIS, NUBE, PALOMA, OLIVO, HOJA, LUZ |
| 82 | 3 | Normal | RAMA, TIERRA, CAMPO, VIDA, PACTO, PROMESA |
| 83 | 3 | Normal | PAZ, ESPERAR, CONFIAR, CUIDADO, CAMINO, NUEVO, FUTURO |
| 84 | 3 | Normal | COLORES, LUZ, AMOR, FAMILIA, ARCOIRIS, VIDA, PACTO |
| 85 | 3 | Normal | NUBE, PALOMA, OLIVO, HOJA, RAMA, TIERRA, CAMPO |
| 86 | 3 | Normal | VIDA, PACTO, PROMESA, PAZ, ESPERAR, CONFIAR, CUIDADO |
| 87 | 3 | Normal | CAMINO, NUEVO, FUTURO, COLORES, LUZ, AMOR, RAMA |
| 88 | 3 | Normal | FAMILIA, ARCOIRIS, NUBE, PALOMA, OLIVO, HOJA, COLOR |
| 89 | 3 | Normal | RAMA, TIERRA, CAMPO, VIDA, PACTO, PROMESA, PAZ |
| 90 | 3 | **Final de mundo** | ESPERAR, CONFIAR, CUIDADO, CAMINO, NUEVO, FUTURO, COLORES, LUZ |

### Mundo 4 — Abraham y las promesas

**Episodio 1: El camino de Abraham (niveles 91–100).** Biblia: Génesis 12:1–21:7. Valor: Confianza. Mensaje editorial sugerido: «Avanzar con confianza también requiere paciencia.»

**Episodio 2: La familia de Isaac y Jacob (niveles 101–110).** Biblia: Génesis 24–35. Valor: Familia. Mensaje editorial sugerido: «El respeto hace bien a la vida en familia.»

**Episodio 3: José y el reencuentro (niveles 111–120).** Biblia: Génesis 37–50. Valor: Perdón. Mensaje editorial sugerido: «El reencuentro de José invita a reflexionar sobre el perdón.»

**Reto misterioso del nivel 110:** PERDON. Pista: «Actitud que nos invita a reparar el daño y buscar una convivencia mejor.».

| Nivel | Episodio | Tipo | Palabras exactas que buscará el jugador |
|---:|:---:|---|---|
| 91 | 1 | Normal | ABRAHAM, SARA, CANAAN, CAMINO, VIAJE, TIENDA |
| 92 | 1 | Normal | FAMILIA, CONFIANZA, PROMESA, AMOR, JUNTOS, CAMPO |
| 93 | 1 | Normal | HOGAR, ESPERAR, CUIDAR, PACTO, PAZ, ALEGRIA |
| 94 | 1 | Normal | CASA, AYUDA, VIAJERO, DESIERTO, BIENVENIDA, AMISTAD |
| 95 | 1 | Normal | ABRAHAM, SARA, CANAAN, CAMINO, VIAJE, TIENDA |
| 96 | 1 | Normal | FAMILIA, CONFIANZA, PROMESA, AMOR, JUNTOS, CAMPO |
| 97 | 1 | Normal | HOGAR, ESPERAR, CUIDAR, PACTO, PAZ, ALEGRIA |
| 98 | 1 | Normal | CASA, AYUDA, VIAJERO, DESIERTO, BIENVENIDA, AMISTAD |
| 99 | 1 | Normal | ABRAHAM, SARA, CANAAN, CAMINO, VIAJE, TIENDA, FAMILIA |
| 100 | 1 | Contrarreloj | CONFIANZA, PROMESA, AMOR, JUNTOS, CAMPO, HOGAR, ESPERAR |
| 101 | 2 | Normal | ISAAC, REBECA, JACOB, ESAU, RAQUEL, LEA, FAMILIA |
| 102 | 2 | Normal | HERMANOS, HOGAR, PADRE, MADRE, UNIDOS, PERDON, RESPETO |
| 103 | 2 | Normal | TRATO, CAMBIO, ENCUENTRO, PROMESA, CAMINO, CONFIANZA, ABRAZO |
| 104 | 2 | Normal | CUIDADO, AMISTAD, REUNION, ISAAC, REBECA, JACOB, ESAU |
| 105 | 2 | Normal | RAQUEL, LEA, FAMILIA, HERMANOS, HOGAR, PADRE, MADRE |
| 106 | 2 | Normal | UNIDOS, PERDON, RESPETO, TRATO, CAMBIO, ENCUENTRO, PROMESA |
| 107 | 2 | Normal | CAMINO, CONFIANZA, ABRAZO, CUIDADO, AMISTAD, REUNION, ISAAC |
| 108 | 2 | Normal | REBECA, JACOB, ESAU, RAQUEL, LEA, FAMILIA, HERMANOS |
| 109 | 2 | Normal | HOGAR, PADRE, MADRE, UNIDOS, PERDON, RESPETO, TRATO |
| 110 | 2 | **Misterio: PERDON** | CAMBIO, ENCUENTRO, PROMESA, CAMINO, CONFIANZA, ABRAZO, CUIDADO |
| 111 | 3 | Normal | JOSE, EGIPTO, HERMANOS, FARAON, SUENOS, TRIGO, GRANERO |
| 112 | 3 | Normal | ALIMENTO, CUIDADO, PERDON, ABRAZO, PAZ, FAMILIA, AYUDA |
| 113 | 3 | Normal | REGRESO, CONFIANZA, ESPERAR, APOYAR, COMPARTIR, CAMBIO, BONDAD, VIDA |
| 114 | 3 | Normal | CASA, GENEROSO, JOSE, EGIPTO, HERMANOS, FARAON, SUENOS, TRIGO |
| 115 | 3 | Normal | GRANERO, ALIMENTO, CUIDADO, PERDON, ABRAZO, PAZ, FAMILIA, AYUDA |
| 116 | 3 | Normal | REGRESO, CONFIANZA, ESPERAR, APOYAR, COMPARTIR, CAMBIO, BONDAD, VIDA |
| 117 | 3 | Normal | CASA, GENEROSO, JOSE, EGIPTO, HERMANOS, FARAON, SUENOS, TRIGO |
| 118 | 3 | Normal | GRANERO, ALIMENTO, CUIDADO, PERDON, ABRAZO, PAZ, FAMILIA, AYUDA |
| 119 | 3 | Normal | REGRESO, CONFIANZA, ESPERAR, APOYAR, COMPARTIR, CAMBIO, BONDAD, VIDA |
| 120 | 3 | **Final de mundo** | CASA, GENEROSO, JOSE, EGIPTO, HERMANOS, FARAON, SUENOS, TRIGO, GRANERO |

### Mundo 5 — Moisés, libertad y justicia

**Episodio 1: El llamado de Moisés (niveles 121–130).** Biblia: Éxodo 1–5. Valor: Valentía. Mensaje editorial sugerido: «Actuar con valentía puede significar ayudar a alguien.»

**Episodio 2: El camino a la libertad (niveles 131–140).** Biblia: Éxodo 12–17. Valor: Libertad. Mensaje editorial sugerido: «La libertad también supone responsabilidad con los demás.»

**Episodio 3: Leyes, líderes y profetas (niveles 141–150).** Biblia: Éxodo 19–20; 1 Samuel 16; Isaías 6. Valor: Justicia. Mensaje editorial sugerido: «La justicia crece cuando escuchamos y tratamos con respeto.»

**Reto misterioso del nivel 140:** JUSTICIA. Pista: «Valor que nos invita a actuar con respeto y dar a cada persona un trato digno.».

| Nivel | Episodio | Tipo | Palabras exactas que buscará el jugador |
|---:|:---:|---|---|
| 121 | 1 | Normal | MOISES, MIRIAM, AARON, EGIPTO, FARAON, PUEBLO, FAMILIA |
| 122 | 1 | Normal | AYUDA, AGUA, RIO, CANASTA, VALENTIA, CUIDADO, CONFIAR |
| 123 | 1 | Normal | APOYAR, LIBERTAD, VIAJE, SALIDA, ESPERAR, UNIDOS, JUSTICIA |
| 124 | 1 | Normal | CAMINO, MAR, MANO, MOISES, MIRIAM, AARON, EGIPTO |
| 125 | 1 | Normal | FARAON, PUEBLO, FAMILIA, AYUDA, AGUA, RIO, CANASTA |
| 126 | 1 | Normal | VALENTIA, CUIDADO, CONFIAR, APOYAR, LIBERTAD, VIAJE, SALIDA |
| 127 | 1 | Normal | ESPERAR, UNIDOS, JUSTICIA, CAMINO, MAR, MANO, MOISES |
| 128 | 1 | Normal | MIRIAM, AARON, EGIPTO, FARAON, PUEBLO, FAMILIA, AYUDA |
| 129 | 1 | Normal | AGUA, RIO, CANASTA, VALENTIA, CUIDADO, CONFIAR, APOYAR, LIBERTAD |
| 130 | 1 | Contrarreloj | VIAJE, SALIDA, ESPERAR, UNIDOS, JUSTICIA, CAMINO, MAR, MANO |
| 131 | 2 | Normal | MAR, CAMINO, ARENA, AGUA, CIELO, PUEBLO, MOISES, LIBERTAD |
| 132 | 2 | Normal | VALENTIA, AYUDA, MANO, NUBE, MANA, PAN, DESIERTO, ESCUCHA |
| 133 | 2 | Normal | RESPETO, CONFIAR, JUNTOS, AVANCE, MONTE, SINAI, CUIDADO, PAZ |
| 134 | 2 | Normal | MAR, CAMINO, ARENA, AGUA, CIELO, PUEBLO, MOISES, LIBERTAD |
| 135 | 2 | Normal | VALENTIA, AYUDA, MANO, NUBE, MANA, PAN, DESIERTO, ESCUCHA |
| 136 | 2 | Normal | RESPETO, CONFIAR, JUNTOS, AVANCE, MONTE, SINAI, CUIDADO, PAZ |
| 137 | 2 | Normal | MAR, CAMINO, ARENA, AGUA, CIELO, PUEBLO, MOISES, LIBERTAD |
| 138 | 2 | Normal | VALENTIA, AYUDA, MANO, NUBE, MANA, PAN, DESIERTO, ESCUCHA |
| 139 | 2 | Normal | RESPETO, CONFIAR, JUNTOS, AVANCE, MONTE, SINAI, CUIDADO, PAZ |
| 140 | 2 | **Misterio: JUSTICIA** | MAR, CAMINO, ARENA, AGUA, CIELO, PUEBLO, MOISES, LIBERTAD |
| 141 | 3 | Normal | TABLAS, LEY, NORMAS, CUIDADO, JUSTICIA, RESPETO, AYUDA, PUEBLO |
| 142 | 3 | Normal | DAVID, SAMUEL, ISAIAS, PROFETA, REYES, LIDER, GUIAR, ESCUCHA |
| 143 | 3 | Normal | SERVICIO, BONDAD, CANTOS, SALMOS, CAMINO, UNIDOS, VALENTIA, HUMILDAD, TABLAS |
| 144 | 3 | Normal | LEY, NORMAS, CUIDADO, JUSTICIA, RESPETO, AYUDA, PUEBLO, DAVID, SAMUEL |
| 145 | 3 | Normal | ISAIAS, PROFETA, REYES, LIDER, GUIAR, ESCUCHA, SERVICIO, BONDAD, CANTOS |
| 146 | 3 | Normal | SALMOS, CAMINO, UNIDOS, VALENTIA, HUMILDAD, TABLAS, LEY, NORMAS, CUIDADO |
| 147 | 3 | Normal | JUSTICIA, RESPETO, AYUDA, PUEBLO, DAVID, SAMUEL, ISAIAS, PROFETA, REYES |
| 148 | 3 | Normal | LIDER, GUIAR, ESCUCHA, SERVICIO, BONDAD, CANTOS, SALMOS, CAMINO, UNIDOS |
| 149 | 3 | Normal | VALENTIA, HUMILDAD, TABLAS, LEY, NORMAS, CUIDADO, JUSTICIA, RESPETO, AYUDA |
| 150 | 3 | **Final de mundo** | PUEBLO, DAVID, SAMUEL, ISAIAS, PROFETA, REYES, LIDER, GUIAR, ESCUCHA, SERVICIO |

### Mundo 6 — Jesús y su familia

**Episodio 1: La noticia del nacimiento (niveles 151–160).** Biblia: Lucas 1:26–56; Mateo 1:18–25. Valor: Confianza. Mensaje editorial sugerido: «Una buena noticia puede compartirse con cariño.»

**Episodio 2: Jesús nace en Belén (niveles 161–170).** Biblia: Lucas 2:1–20; Mateo 2:1–12. Valor: Alegría. Mensaje editorial sugerido: «La bienvenida y el cuidado son gestos de amor.»

**Episodio 3: La familia y el aprendizaje (niveles 171–180).** Biblia: Lucas 2:21–52. Valor: Cuidado. Mensaje editorial sugerido: «Los Evangelios narran algunos momentos de la infancia de Jesús.»

**Reto misterioso del nivel 170:** ALEGRIA. Pista: «Emoción que podemos compartir al recibir una buena noticia.».

| Nivel | Episodio | Tipo | Palabras exactas que buscará el jugador |
|---:|:---:|---|---|
| 151 | 1 | Normal | MARIA, JOSE, ANGEL, NAZARET, BELEN, FAMILIA, ESPERAR, ALEGRIA |
| 152 | 1 | Normal | MENSAJE, CUIDADO, AMOR, HOGAR, CONFIAR, VIAJE, PADRE, MADRE |
| 153 | 1 | Normal | VIDA, BIENVENIDA, LUZ, PAZ, JUNTOS, CARINO, CASA, NOTICIA |
| 154 | 1 | Normal | PROMESA, MARIA, JOSE, ANGEL, NAZARET, BELEN, FAMILIA, ESPERAR |
| 155 | 1 | Normal | ALEGRIA, MENSAJE, CUIDADO, AMOR, HOGAR, CONFIAR, VIAJE, PADRE |
| 156 | 1 | Normal | MADRE, VIDA, BIENVENIDA, LUZ, PAZ, JUNTOS, CARINO, CASA |
| 157 | 1 | Normal | NOTICIA, PROMESA, MARIA, JOSE, ANGEL, NAZARET, BELEN, FAMILIA |
| 158 | 1 | Normal | ESPERAR, ALEGRIA, MENSAJE, CUIDADO, AMOR, HOGAR, CONFIAR, VIAJE |
| 159 | 1 | Normal | PADRE, MADRE, VIDA, BIENVENIDA, LUZ, PAZ, JUNTOS, CARINO, CASA |
| 160 | 1 | Contrarreloj | NOTICIA, PROMESA, MARIA, JOSE, ANGEL, NAZARET, BELEN, FAMILIA, ESPERAR |
| 161 | 2 | Normal | JESUS, BELEN, MARIA, JOSE, PESEBRE, PASTORES, OVEJAS, NOCHE, ESTRELLA |
| 162 | 2 | Normal | ALEGRIA, AMOR, REGALO, VISITA, VIDA, HOGAR, FAMILIA, COMPARTIR, PAZ |
| 163 | 2 | Normal | CUIDADO, NACER, TIERRA, LUZ, CAMINO, BIENVENIDA, CUNA, JESUS, BELEN |
| 164 | 2 | Normal | MARIA, JOSE, PESEBRE, PASTORES, OVEJAS, NOCHE, ESTRELLA, ALEGRIA, AMOR |
| 165 | 2 | Normal | REGALO, VISITA, VIDA, HOGAR, FAMILIA, COMPARTIR, PAZ, CUIDADO, NACER |
| 166 | 2 | Normal | TIERRA, LUZ, CAMINO, BIENVENIDA, CUNA, JESUS, BELEN, MARIA, JOSE |
| 167 | 2 | Normal | PESEBRE, PASTORES, OVEJAS, NOCHE, ESTRELLA, ALEGRIA, AMOR, REGALO, VISITA |
| 168 | 2 | Normal | VIDA, HOGAR, FAMILIA, COMPARTIR, PAZ, CUIDADO, NACER, TIERRA, LUZ |
| 169 | 2 | Normal | CAMINO, BIENVENIDA, CUNA, JESUS, BELEN, MARIA, JOSE, PESEBRE, PASTORES |
| 170 | 2 | **Misterio: ALEGRIA** | OVEJAS, NOCHE, ESTRELLA, AMOR, REGALO, VISITA, VIDA, HOGAR, FAMILIA |
| 171 | 3 | Normal | JESUS, MARIA, JOSE, TEMPLO, SIMEON, ANA, SABIDURIA, FAMILIA, CUIDADO |
| 172 | 3 | Normal | RESPETO, ALEGRIA, APRENDER, ESCUCHA, CRECER, CAMINO, PADRES, HOGAR, CONFIAR |
| 173 | 3 | Normal | AMOR, PAZ, ENCUENTRO, COMPRENDER, PREGUNTA, RESPONDER, JESUS, MARIA, JOSE, TEMPLO |
| 174 | 3 | Normal | SIMEON, ANA, SABIDURIA, FAMILIA, CUIDADO, RESPETO, ALEGRIA, APRENDER, ESCUCHA, CRECER |
| 175 | 3 | Normal | CAMINO, PADRES, HOGAR, CONFIAR, AMOR, PAZ, ENCUENTRO, COMPRENDER, PREGUNTA, RESPONDER |
| 176 | 3 | Normal | JESUS, MARIA, JOSE, TEMPLO, SIMEON, ANA, SABIDURIA, FAMILIA, CUIDADO, RESPETO |
| 177 | 3 | Normal | ALEGRIA, APRENDER, ESCUCHA, CRECER, CAMINO, PADRES, HOGAR, CONFIAR, AMOR, PAZ |
| 178 | 3 | Normal | ENCUENTRO, COMPRENDER, PREGUNTA, RESPONDER, JESUS, MARIA, JOSE, TEMPLO, SIMEON, ANA |
| 179 | 3 | Normal | SABIDURIA, FAMILIA, CUIDADO, RESPETO, ALEGRIA, APRENDER, ESCUCHA, CRECER, CAMINO, PADRES |
| 180 | 3 | **Final de mundo** | HOGAR, CONFIAR, AMOR, PAZ, ENCUENTRO, COMPRENDER, PREGUNTA, RESPONDER, JESUS, MARIA, JOSE |

### Mundo 7 — Jesús nos enseña a amar

**Episodio 1: El amor y el buen trato (niveles 181–190).** Biblia: Mateo 5:1–12; Mateo 5:43–48. Valor: Amor. Mensaje editorial sugerido: «El respeto y la bondad hacen más amable nuestra convivencia.»

**Episodio 2: El prójimo y la ayuda (niveles 191–200).** Biblia: Lucas 10:25–37. Valor: Solidaridad. Mensaje editorial sugerido: «Ayudar a quien lo necesita es una manera de amar.»

**Episodio 3: Oración, perdón y confianza (niveles 201–210).** Biblia: Mateo 6:5–15; Mateo 7:24–27. Valor: Paz. Mensaje editorial sugerido: «Escuchar, perdonar y cuidar son gestos para la vida diaria.»

**Reto misterioso del nivel 200:** BONDAD. Pista: «Actitud que se nota cuando hacemos el bien a las personas.».

| Nivel | Episodio | Tipo | Palabras exactas que buscará el jugador |
|---:|:---:|---|---|
| 181 | 1 | Normal | JESUS, AMOR, PAZ, BONDAD, JUSTICIA, HUMILDAD, RESPETO, CUIDADO, ESCUCHA |
| 182 | 1 | Normal | CORAZON, AMABLE, ALEGRIA, CONFIANZA, PALABRAS, PERDON, ESPERANZA, VIDA, BIEN |
| 183 | 1 | Normal | AYUDA, SERVICIO, CONSUELO, AMISTAD, VERDAD, PERSONAS, BENDICION, COMPASION, JESUS |
| 184 | 1 | Normal | AMOR, PAZ, BONDAD, JUSTICIA, HUMILDAD, RESPETO, CUIDADO, ESCUCHA, CORAZON |
| 185 | 1 | Normal | AMABLE, ALEGRIA, CONFIANZA, PALABRAS, PERDON, ESPERANZA, VIDA, BIEN, AYUDA |
| 186 | 1 | Normal | SERVICIO, CONSUELO, AMISTAD, VERDAD, PERSONAS, BENDICION, COMPASION, JESUS, AMOR |
| 187 | 1 | Normal | PAZ, BONDAD, JUSTICIA, HUMILDAD, RESPETO, CUIDADO, ESCUCHA, CORAZON, AMABLE |
| 188 | 1 | Normal | ALEGRIA, CONFIANZA, PALABRAS, PERDON, ESPERANZA, VIDA, BIEN, AYUDA, SERVICIO |
| 189 | 1 | Normal | CONSUELO, AMISTAD, VERDAD, PERSONAS, BENDICION, COMPASION, JESUS, AMOR, PAZ, BONDAD |
| 190 | 1 | Contrarreloj | JUSTICIA, HUMILDAD, RESPETO, CUIDADO, ESCUCHA, CORAZON, AMABLE, ALEGRIA, CONFIANZA, PALABRAS |
| 191 | 2 | Normal | PARABOLA, PROJIMO, VIAJERO, CAMINO, HERIDO, AYUDAR, SAMARITANO, AMOR, COMPASION, RESPETO |
| 192 | 2 | Normal | CUIDADO, TIEMPO, ESCUCHA, BONDAD, AYUDA, SERVICIO, GENEROSO, CERCANIA, SOLIDARIO, AMISTAD |
| 193 | 2 | Normal | JUSTICIA, PAZ, AGRADECER, PARABOLA, PROJIMO, VIAJERO, CAMINO, HERIDO, AYUDAR, SAMARITANO |
| 194 | 2 | Normal | AMOR, COMPASION, RESPETO, CUIDADO, TIEMPO, ESCUCHA, BONDAD, AYUDA, SERVICIO, GENEROSO |
| 195 | 2 | Normal | CERCANIA, SOLIDARIO, AMISTAD, JUSTICIA, PAZ, AGRADECER, PARABOLA, PROJIMO, VIAJERO, CAMINO |
| 196 | 2 | Normal | HERIDO, AYUDAR, SAMARITANO, AMOR, COMPASION, RESPETO, CUIDADO, TIEMPO, ESCUCHA, BONDAD |
| 197 | 2 | Normal | AYUDA, SERVICIO, GENEROSO, CERCANIA, SOLIDARIO, AMISTAD, JUSTICIA, PAZ, AGRADECER, PARABOLA |
| 198 | 2 | Normal | PROJIMO, VIAJERO, CAMINO, HERIDO, AYUDAR, SAMARITANO, AMOR, COMPASION, RESPETO, CUIDADO |
| 199 | 2 | Normal | TIEMPO, ESCUCHA, BONDAD, AYUDA, SERVICIO, GENEROSO, CERCANIA, SOLIDARIO, AMISTAD, JUSTICIA |
| 200 | 2 | **Misterio: BONDAD** | PAZ, AGRADECER, PARABOLA, PROJIMO, VIAJERO, CAMINO, HERIDO, AYUDAR, SAMARITANO, AMOR |
| 201 | 3 | Normal | PADRE, ORACION, JESUS, ESCUCHA, PAZ, PERDON, GRATITUD, AMOR, RESPETO, CONFIANZA |
| 202 | 3 | Normal | ESPERANZA, COMPARTIR, CUIDAR, HUMILDAD, CORAZON, BONDAD, PALABRAS, PREGUNTAR, REFLEXION, AYUDA |
| 203 | 3 | Normal | CORDIALIDAD, ENTUSIASMO, SINCERO, AMABLE, PADRE, ORACION, JESUS, ESCUCHA, PAZ, PERDON, GRATITUD |
| 204 | 3 | Normal | AMOR, RESPETO, CONFIANZA, ESPERANZA, COMPARTIR, CUIDAR, HUMILDAD, CORAZON, BONDAD, PALABRAS, PREGUNTAR |
| 205 | 3 | Normal | REFLEXION, AYUDA, CORDIALIDAD, ENTUSIASMO, SINCERO, AMABLE, PADRE, ORACION, JESUS, ESCUCHA, PAZ |
| 206 | 3 | Normal | PERDON, GRATITUD, AMOR, RESPETO, CONFIANZA, ESPERANZA, COMPARTIR, CUIDAR, HUMILDAD, CORAZON, BONDAD |
| 207 | 3 | Normal | PALABRAS, PREGUNTAR, REFLEXION, AYUDA, CORDIALIDAD, ENTUSIASMO, SINCERO, AMABLE, PADRE, ORACION, JESUS |
| 208 | 3 | Normal | ESCUCHA, PAZ, PERDON, GRATITUD, AMOR, RESPETO, CONFIANZA, ESPERANZA, COMPARTIR, CUIDAR, HUMILDAD |
| 209 | 3 | Normal | CORAZON, BONDAD, PALABRAS, PREGUNTAR, REFLEXION, AYUDA, CORDIALIDAD, ENTUSIASMO, SINCERO, AMABLE, PADRE |
| 210 | 3 | **Final de mundo** | ORACION, JESUS, ESCUCHA, PAZ, PERDON, GRATITUD, AMOR, RESPETO, CONFIANZA, ESPERANZA, COMPARTIR, CUIDAR |

### Mundo 8 — Jesús y sus amigos

**Episodio 1: Jesús llama a sus discípulos (niveles 211–220).** Biblia: Marcos 1:16–20; Lucas 5:1–11. Valor: Confianza. Mensaje editorial sugerido: «Escuchar y aprender en compañía nos ayuda a crecer.»

**Episodio 2: Personas que acompañan a Jesús (niveles 221–230).** Biblia: Lucas 10:38–42; Juan 11. Valor: Escucha. Mensaje editorial sugerido: «La amistad también acompaña en momentos difíciles.»

**Episodio 3: Aprender a cuidar la amistad (niveles 231–240).** Biblia: Marcos 3:13–19; Juan 15:12–17. Valor: Amistad. Mensaje editorial sugerido: «Compartir, apoyar y respetar son gestos de amistad.»

**Reto misterioso del nivel 230:** AMISTAD. Pista: «Vínculo que se fortalece al escuchar, acompañar y compartir.».

| Nivel | Episodio | Tipo | Palabras exactas que buscará el jugador |
|---:|:---:|---|---|
| 211 | 1 | Normal | JESUS, PEDRO, ANDRES, JUAN, SANTIAGO, MATEO, AMIGOS, BARCAS, REDES, LAGO |
| 212 | 1 | Normal | PESCA, GALILEA, CAMINO, LLAMADO, ESCUCHA, CONFIANZA, COMPARTIR, JUNTOS, AMISTAD, SERVICIO |
| 213 | 1 | Normal | APOYO, EQUIPO, AYUDA, CUIDADO, JESUS, PEDRO, ANDRES, JUAN, SANTIAGO, MATEO |
| 214 | 1 | Normal | AMIGOS, BARCAS, REDES, LAGO, PESCA, GALILEA, CAMINO, LLAMADO, ESCUCHA, CONFIANZA |
| 215 | 1 | Normal | COMPARTIR, JUNTOS, AMISTAD, SERVICIO, APOYO, EQUIPO, AYUDA, CUIDADO, JESUS, PEDRO |
| 216 | 1 | Normal | ANDRES, JUAN, SANTIAGO, MATEO, AMIGOS, BARCAS, REDES, LAGO, PESCA, GALILEA |
| 217 | 1 | Normal | CAMINO, LLAMADO, ESCUCHA, CONFIANZA, COMPARTIR, JUNTOS, AMISTAD, SERVICIO, APOYO, EQUIPO |
| 218 | 1 | Normal | AYUDA, CUIDADO, JESUS, PEDRO, ANDRES, JUAN, SANTIAGO, MATEO, AMIGOS, BARCAS |
| 219 | 1 | Normal | REDES, LAGO, PESCA, GALILEA, CAMINO, LLAMADO, ESCUCHA, CONFIANZA, COMPARTIR, JUNTOS, AMISTAD |
| 220 | 1 | Contrarreloj | SERVICIO, APOYO, EQUIPO, AYUDA, CUIDADO, JESUS, PEDRO, ANDRES, JUAN, SANTIAGO, MATEO |
| 221 | 2 | Normal | MARTA, MARIA, LAZARO, JESUS, HOGAR, AMISTAD, ESCUCHA, CUIDADO, CONFIANZA, AMOR, PALABRAS |
| 222 | 2 | Normal | CONSUELO, LAGRIMAS, ACOMPANAR, APOYAR, RESPETO, FAMILIA, HERMANOS, REUNION, VISITA, CERCANIA, ESPERANZA |
| 223 | 2 | Normal | SERVICIO, BONDAD, MARTA, MARIA, LAZARO, JESUS, HOGAR, AMISTAD, ESCUCHA, CUIDADO, CONFIANZA |
| 224 | 2 | Normal | AMOR, PALABRAS, CONSUELO, LAGRIMAS, ACOMPANAR, APOYAR, RESPETO, FAMILIA, HERMANOS, REUNION, VISITA |
| 225 | 2 | Normal | CERCANIA, ESPERANZA, SERVICIO, BONDAD, MARTA, MARIA, LAZARO, JESUS, HOGAR, AMISTAD, ESCUCHA |
| 226 | 2 | Normal | CUIDADO, CONFIANZA, AMOR, PALABRAS, CONSUELO, LAGRIMAS, ACOMPANAR, APOYAR, RESPETO, FAMILIA, HERMANOS |
| 227 | 2 | Normal | REUNION, VISITA, CERCANIA, ESPERANZA, SERVICIO, BONDAD, MARTA, MARIA, LAZARO, JESUS, HOGAR |
| 228 | 2 | Normal | AMISTAD, ESCUCHA, CUIDADO, CONFIANZA, AMOR, PALABRAS, CONSUELO, LAGRIMAS, ACOMPANAR, APOYAR, RESPETO |
| 229 | 2 | Normal | FAMILIA, HERMANOS, REUNION, VISITA, CERCANIA, ESPERANZA, SERVICIO, BONDAD, MARTA, MARIA, LAZARO |
| 230 | 2 | **Misterio: AMISTAD** | JESUS, HOGAR, ESCUCHA, CUIDADO, CONFIANZA, AMOR, PALABRAS, CONSUELO, LAGRIMAS, ACOMPANAR, APOYAR |
| 231 | 3 | Normal | PEDRO, JUAN, TOMAS, MATEO, DISCIPULOS, AMIGOS, UNIDOS, AMISTAD, SERVICIO, COMPARTIR, CONFIANZA |
| 232 | 3 | Normal | AYUDA, RESPETO, ESCUCHA, CAMINO, APRENDER, JUNTOS, APOYAR, BONDAD, ENCUENTRO, ALEGRIA, COLABORAR |
| 233 | 3 | Normal | ESPERANZA, PERDON, PEDRO, JUAN, TOMAS, MATEO, DISCIPULOS, AMIGOS, UNIDOS, AMISTAD, SERVICIO, COMPARTIR |
| 234 | 3 | Normal | CONFIANZA, AYUDA, RESPETO, ESCUCHA, CAMINO, APRENDER, JUNTOS, APOYAR, BONDAD, ENCUENTRO, ALEGRIA, COLABORAR |
| 235 | 3 | Normal | ESPERANZA, PERDON, PEDRO, JUAN, TOMAS, MATEO, DISCIPULOS, AMIGOS, UNIDOS, AMISTAD, SERVICIO, COMPARTIR |
| 236 | 3 | Normal | CONFIANZA, AYUDA, RESPETO, ESCUCHA, CAMINO, APRENDER, JUNTOS, APOYAR, BONDAD, ENCUENTRO, ALEGRIA, COLABORAR |
| 237 | 3 | Normal | ESPERANZA, PERDON, PEDRO, JUAN, TOMAS, MATEO, DISCIPULOS, AMIGOS, UNIDOS, AMISTAD, SERVICIO, COMPARTIR |
| 238 | 3 | Normal | CONFIANZA, AYUDA, RESPETO, ESCUCHA, CAMINO, APRENDER, JUNTOS, APOYAR, BONDAD, ENCUENTRO, ALEGRIA, COLABORAR |
| 239 | 3 | Normal | ESPERANZA, PERDON, PEDRO, JUAN, TOMAS, MATEO, DISCIPULOS, AMIGOS, UNIDOS, AMISTAD, SERVICIO, COMPARTIR |
| 240 | 3 | **Final de mundo** | CONFIANZA, AYUDA, RESPETO, ESCUCHA, CAMINO, APRENDER, JUNTOS, APOYAR, BONDAD, ENCUENTRO, ALEGRIA, COLABORAR, ESPERANZA |

### Mundo 9 — Jesús vive: amor y esperanza

**Episodio 1: Compartir y servir (niveles 241–250).** Biblia: Lucas 22:7–38; Juan 13:1–17. Valor: Servicio. Mensaje editorial sugerido: «El amor puede mostrarse cuando compartimos y servimos.»

**Episodio 2: El amor en momentos difíciles (niveles 251–260).** Biblia: Lucas 23; Juan 19. Valor: Consuelo. Mensaje editorial sugerido: «Ante el dolor, escuchar y acompañar puede ayudar.»

**Episodio 3: La resurrección y la esperanza (niveles 261–270).** Biblia: Lucas 24; Juan 20. Valor: Esperanza. Mensaje editorial sugerido: «La resurrección de Jesús es un mensaje central de esperanza cristiana.»

**Reto misterioso del nivel 260:** CONSUELO. Pista: «Acompañamiento y cuidado que podemos ofrecer a alguien triste.».

| Nivel | Episodio | Tipo | Palabras exactas que buscará el jugador |
|---:|:---:|---|---|
| 241 | 1 | Normal | JESUS, CENA, PAN, COPA, AMOR, AMIGOS, COMPARTIR, SERVICIO, HUMILDAD, PERDON, ESPERANZA |
| 242 | 1 | Normal | ORACION, CUIDADO, ENTREGA, REUNION, PAZ, ESCUCHA, CONFIANZA, PALABRAS, CONVIVIR, AMISTAD, AYUDA |
| 243 | 1 | Normal | MANO, JESUS, CENA, PAN, COPA, AMOR, AMIGOS, COMPARTIR, SERVICIO, HUMILDAD, PERDON |
| 244 | 1 | Normal | ESPERANZA, ORACION, CUIDADO, ENTREGA, REUNION, PAZ, ESCUCHA, CONFIANZA, PALABRAS, CONVIVIR, AMISTAD |
| 245 | 1 | Normal | AYUDA, MANO, JESUS, CENA, PAN, COPA, AMOR, AMIGOS, COMPARTIR, SERVICIO, HUMILDAD |
| 246 | 1 | Normal | PERDON, ESPERANZA, ORACION, CUIDADO, ENTREGA, REUNION, PAZ, ESCUCHA, CONFIANZA, PALABRAS, CONVIVIR |
| 247 | 1 | Normal | AMISTAD, AYUDA, MANO, JESUS, CENA, PAN, COPA, AMOR, AMIGOS, COMPARTIR, SERVICIO |
| 248 | 1 | Normal | HUMILDAD, PERDON, ESPERANZA, ORACION, CUIDADO, ENTREGA, REUNION, PAZ, ESCUCHA, CONFIANZA, PALABRAS |
| 249 | 1 | Normal | CONVIVIR, AMISTAD, AYUDA, MANO, JESUS, CENA, PAN, COPA, AMOR, AMIGOS, COMPARTIR, SERVICIO |
| 250 | 1 | Contrarreloj | HUMILDAD, PERDON, ESPERANZA, ORACION, CUIDADO, ENTREGA, REUNION, PAZ, ESCUCHA, CONFIANZA, PALABRAS, CONVIVIR |
| 251 | 2 | Normal | JESUS, CRUZ, MARIA, AMOR, CONSUELO, ORACION, CUIDADO, RESPETO, DOLOR, ACOMPANAR, TRISTEZA, ESPERANZA |
| 252 | 2 | Normal | APOYO, AMISTAD, SILENCIO, VIDA, PAZ, COMPASION, CONFIANZA, CAMINO, PERDON, FAMILIA, ABRAZO, JESUS |
| 253 | 2 | Normal | CRUZ, MARIA, AMOR, CONSUELO, ORACION, CUIDADO, RESPETO, DOLOR, ACOMPANAR, TRISTEZA, ESPERANZA, APOYO |
| 254 | 2 | Normal | AMISTAD, SILENCIO, VIDA, PAZ, COMPASION, CONFIANZA, CAMINO, PERDON, FAMILIA, ABRAZO, JESUS, CRUZ |
| 255 | 2 | Normal | MARIA, AMOR, CONSUELO, ORACION, CUIDADO, RESPETO, DOLOR, ACOMPANAR, TRISTEZA, ESPERANZA, APOYO, AMISTAD |
| 256 | 2 | Normal | SILENCIO, VIDA, PAZ, COMPASION, CONFIANZA, CAMINO, PERDON, FAMILIA, ABRAZO, JESUS, CRUZ, MARIA |
| 257 | 2 | Normal | AMOR, CONSUELO, ORACION, CUIDADO, RESPETO, DOLOR, ACOMPANAR, TRISTEZA, ESPERANZA, APOYO, AMISTAD, SILENCIO |
| 258 | 2 | Normal | VIDA, PAZ, COMPASION, CONFIANZA, CAMINO, PERDON, FAMILIA, ABRAZO, JESUS, CRUZ, MARIA, AMOR |
| 259 | 2 | Normal | CONSUELO, ORACION, CUIDADO, RESPETO, DOLOR, ACOMPANAR, TRISTEZA, ESPERANZA, APOYO, AMISTAD, SILENCIO, VIDA |
| 260 | 2 | **Misterio: CONSUELO** | PAZ, COMPASION, CONFIANZA, CAMINO, PERDON, FAMILIA, ABRAZO, JESUS, CRUZ, MARIA, AMOR, ORACION |
| 261 | 3 | Normal | JESUS, TUMBA, PIEDRA, MARIA, VIVIR, VIDA, ALEGRIA, ESPERANZA, PAZ, CONSUELO, REUNION, ENCUENTRO |
| 262 | 3 | Normal | AMIGOS, RESUCITO, RESURRECCION, NUEVO, CAMINO, CONFIANZA, COMPARTIR, AMOR, BUENAS, NOTICIAS, JESUS, PAZ |
| 263 | 3 | Normal | TUMBA, PIEDRA, MARIA, VIVIR, VIDA, ALEGRIA, ESPERANZA, PAZ, CONSUELO, REUNION, ENCUENTRO, AMIGOS, RESUCITO |
| 264 | 3 | Normal | RESURRECCION, NUEVO, CAMINO, CONFIANZA, COMPARTIR, AMOR, BUENAS, NOTICIAS, JESUS, TUMBA, PIEDRA, MARIA, PAZ |
| 265 | 3 | Normal | VIVIR, VIDA, ALEGRIA, ESPERANZA, PAZ, CONSUELO, REUNION, ENCUENTRO, AMIGOS, RESUCITO, RESURRECCION, NUEVO, CAMINO |
| 266 | 3 | Normal | CONFIANZA, COMPARTIR, AMOR, BUENAS, NOTICIAS, JESUS, TUMBA, PIEDRA, MARIA, VIVIR, VIDA, ALEGRIA, PAZ |
| 267 | 3 | Normal | ESPERANZA, PAZ, CONSUELO, REUNION, ENCUENTRO, AMIGOS, RESUCITO, RESURRECCION, NUEVO, CAMINO, CONFIANZA, COMPARTIR, AMOR |
| 268 | 3 | Normal | BUENAS, NOTICIAS, JESUS, TUMBA, PIEDRA, MARIA, VIVIR, VIDA, ALEGRIA, ESPERANZA, PAZ, CONSUELO, AMOR |
| 269 | 3 | Normal | REUNION, ENCUENTRO, AMIGOS, RESUCITO, RESURRECCION, NUEVO, CAMINO, CONFIANZA, COMPARTIR, AMOR, BUENAS, NOTICIAS, PAZ |
| 270 | 3 | **Final de mundo** | JESUS, TUMBA, PIEDRA, MARIA, VIVIR, VIDA, ALEGRIA, ESPERANZA, PAZ, CONSUELO, REUNION, ENCUENTRO, AMIGOS, RESUCITO |

### Mundo 10 — Una comunidad que comparte

**Episodio 1: Vivir en comunidad (niveles 271–280).** Biblia: Hechos 2:42–47. Valor: Unidad. Mensaje editorial sugerido: «La convivencia mejora cuando compartimos con respeto.»

**Episodio 2: La ayuda que se comparte (niveles 281–290).** Biblia: Hechos 4:32–35; Romanos 12:9–18. Valor: Solidaridad. Mensaje editorial sugerido: «Una palabra amable y una ayuda concreta pueden transformar el día.»

**Episodio 3: Amor que se convierte en hechos (niveles 291–300).** Biblia: 1 Corintios 13; Santiago 2:14–17. Valor: Amor. Mensaje editorial sugerido: «El amor también se expresa con hechos y buen trato.»

**Reto misterioso del nivel 290:** AYUDA. Pista: «Gesto que ofrecemos cuando alguien necesita apoyo.».

| Nivel | Episodio | Tipo | Palabras exactas que buscará el jugador |
|---:|:---:|---|---|
| 271 | 1 | Normal | COMUNIDAD, AMIGOS, JUNTOS, AMOR, AYUDA, COMPARTIR, CUIDADO, CERCANIA, SERVICIO, RESPETO, BONDAD, PAZ |
| 272 | 1 | Normal | ALEGRIA, ESPERANZA, ORACION, GRATITUD, PAZ, FAMILIA, UNIDOS, ESCUCHA, APOYO, CONVIVIR, SOLIDARIOS, GENTE |
| 273 | 1 | Normal | COMUNIDAD, AMIGOS, JUNTOS, AMOR, AYUDA, COMPARTIR, CUIDADO, CERCANIA, SERVICIO, RESPETO, BONDAD, PAZ |
| 274 | 1 | Normal | ALEGRIA, ESPERANZA, ORACION, GRATITUD, PAZ, FAMILIA, UNIDOS, ESCUCHA, APOYO, CONVIVIR, SOLIDARIOS, GENTE |
| 275 | 1 | Normal | COMUNIDAD, AMIGOS, JUNTOS, AMOR, AYUDA, COMPARTIR, CUIDADO, CERCANIA, SERVICIO, RESPETO, BONDAD, PAZ |
| 276 | 1 | Normal | ALEGRIA, ESPERANZA, ORACION, GRATITUD, PAZ, FAMILIA, UNIDOS, ESCUCHA, APOYO, CONVIVIR, SOLIDARIOS, GENTE |
| 277 | 1 | Normal | COMUNIDAD, AMIGOS, JUNTOS, AMOR, AYUDA, COMPARTIR, CUIDADO, CERCANIA, SERVICIO, RESPETO, BONDAD, PAZ |
| 278 | 1 | Normal | ALEGRIA, ESPERANZA, ORACION, GRATITUD, PAZ, FAMILIA, UNIDOS, ESCUCHA, APOYO, CONVIVIR, SOLIDARIOS, GENTE |
| 279 | 1 | Normal | COMUNIDAD, AMIGOS, JUNTOS, AMOR, AYUDA, COMPARTIR, CUIDADO, CERCANIA, SERVICIO, RESPETO, BONDAD, ALEGRIA, PAZ |
| 280 | 1 | Contrarreloj | ESPERANZA, ORACION, GRATITUD, PAZ, FAMILIA, UNIDOS, ESCUCHA, APOYO, CONVIVIR, SOLIDARIOS, GENTE, COMUNIDAD, AMIGOS |
| 281 | 2 | Normal | SOLIDARIDAD, GENEROSIDAD, COMPARTIR, AYUDAR, APOYAR, SERVICIO, CORDIALIDAD, RESPETO, AMISTAD, CONSUELO, AMABILIDAD, ENTUSIASMO, ALEGRIA |
| 282 | 2 | Normal | CUIDADO, BONDAD, JUSTICIA, HUMILDAD, AGRADECER, ESCUCHA, CONFIANZA, ABRAZOS, PALABRAS, PREGUNTAR, SONRISA, SOLIDARIDAD, GENEROSIDAD |
| 283 | 2 | Normal | COMPARTIR, AYUDAR, APOYAR, SERVICIO, CORDIALIDAD, RESPETO, AMISTAD, CONSUELO, AMABILIDAD, ENTUSIASMO, ALEGRIA, CUIDADO, BONDAD |
| 284 | 2 | Normal | JUSTICIA, HUMILDAD, AGRADECER, ESCUCHA, CONFIANZA, ABRAZOS, PALABRAS, PREGUNTAR, SONRISA, SOLIDARIDAD, GENEROSIDAD, COMPARTIR, AYUDAR |
| 285 | 2 | Normal | APOYAR, SERVICIO, CORDIALIDAD, RESPETO, AMISTAD, CONSUELO, AMABILIDAD, ENTUSIASMO, ALEGRIA, CUIDADO, BONDAD, JUSTICIA, HUMILDAD |
| 286 | 2 | Normal | AGRADECER, ESCUCHA, CONFIANZA, ABRAZOS, PALABRAS, PREGUNTAR, SONRISA, SOLIDARIDAD, GENEROSIDAD, COMPARTIR, AYUDAR, APOYAR, SERVICIO |
| 287 | 2 | Normal | CORDIALIDAD, RESPETO, AMISTAD, CONSUELO, AMABILIDAD, ENTUSIASMO, ALEGRIA, CUIDADO, BONDAD, JUSTICIA, HUMILDAD, AGRADECER, ESCUCHA |
| 288 | 2 | Normal | CONFIANZA, ABRAZOS, PALABRAS, PREGUNTAR, SONRISA, SOLIDARIDAD, GENEROSIDAD, COMPARTIR, AYUDAR, APOYAR, SERVICIO, CORDIALIDAD, RESPETO |
| 289 | 2 | Normal | AMISTAD, CONSUELO, AMABILIDAD, ENTUSIASMO, ALEGRIA, CUIDADO, BONDAD, JUSTICIA, HUMILDAD, AGRADECER, ESCUCHA, CONFIANZA, ABRAZOS |
| 290 | 2 | **Misterio: AYUDA** | PALABRAS, PREGUNTAR, SONRISA, SOLIDARIDAD, GENEROSIDAD, COMPARTIR, APOYAR, SERVICIO, CORDIALIDAD, RESPETO, AMISTAD, CONSUELO, BONDAD |
| 291 | 3 | Normal | AMOR, PAZ, ESPERANZA, AMISTAD, SOLIDARIDAD, SERVICIO, GENEROSIDAD, CUIDADO, ALEGRIA, CONFIANZA, PERDON, GRATITUD, RESPETO |
| 292 | 3 | Normal | BONDAD, COMPARTIR, ACOMPANAR, AYUDAR, AMABILIDAD, HUMILDAD, ENTUSIASMO, COMUNIDAD, VIDA, CORDIALIDAD, SONRISA, AMOR, PAZ |
| 293 | 3 | Normal | ESPERANZA, AMISTAD, SOLIDARIDAD, SERVICIO, GENEROSIDAD, CUIDADO, ALEGRIA, CONFIANZA, PERDON, GRATITUD, RESPETO, BONDAD, COMPARTIR, ACOMPANAR |
| 294 | 3 | Normal | AYUDAR, AMABILIDAD, HUMILDAD, ENTUSIASMO, COMUNIDAD, VIDA, CORDIALIDAD, SONRISA, AMOR, PAZ, ESPERANZA, AMISTAD, SOLIDARIDAD, SERVICIO |
| 295 | 3 | Normal | GENEROSIDAD, CUIDADO, ALEGRIA, CONFIANZA, PERDON, GRATITUD, RESPETO, BONDAD, COMPARTIR, ACOMPANAR, AYUDAR, AMABILIDAD, HUMILDAD, ENTUSIASMO |
| 296 | 3 | Normal | COMUNIDAD, VIDA, CORDIALIDAD, SONRISA, AMOR, PAZ, ESPERANZA, AMISTAD, SOLIDARIDAD, SERVICIO, GENEROSIDAD, CUIDADO, ALEGRIA, CONFIANZA |
| 297 | 3 | Normal | PERDON, GRATITUD, RESPETO, BONDAD, COMPARTIR, ACOMPANAR, AYUDAR, AMABILIDAD, HUMILDAD, ENTUSIASMO, COMUNIDAD, VIDA, CORDIALIDAD, SONRISA |
| 298 | 3 | Normal | AMOR, PAZ, ESPERANZA, AMISTAD, SOLIDARIDAD, SERVICIO, GENEROSIDAD, CUIDADO, ALEGRIA, CONFIANZA, PERDON, GRATITUD, RESPETO, BONDAD |
| 299 | 3 | Normal | COMPARTIR, ACOMPANAR, AYUDAR, AMABILIDAD, HUMILDAD, ENTUSIASMO, COMUNIDAD, VIDA, CORDIALIDAD, SONRISA, AMOR, PAZ, ESPERANZA, AMISTAD |
| 300 | 3 | **Final de mundo** | SOLIDARIDAD, SERVICIO, GENEROSIDAD, CUIDADO, ALEGRIA, CONFIANZA, PERDON, GRATITUD, RESPETO, BONDAD, COMPARTIR, ACOMPANAR, AYUDAR, AMABILIDAD, HUMILDAD |


## Instrucción inequívoca para agentes implementadores

**El contenido se encuentra cerrado como propuesta editorial a implementar en estos 300 registros.** Ningún agente añade palabras improvisadas, reemplaza vocabulario difícil por sinónimos escogidos a ciegas, altera el orden de mundos o mezcla palabras de otros episodios. El motor debe recibir **exactamente** la lista de cada nivel y hallar una distribución geométrica válida. Si un tablero falla, registrar nivel, palabras y causa, ajustar semilla o algoritmo de colocación; cambiar palabras solo si la Supervisión confirma una razón pedagógica comprobable.

El nivel misterioso debe tener la **solución escrita expresamente en su registro**, además de las palabras normales visibles; el generador anterior de «15 misterios» no la respeta por sí solo y se debe adaptar. Las pistas son ayudas lúdicas y no deben bloquear la victoria.

**Orden fijado por el Humano:** implementar primero estos 300 niveles y la experiencia educativa; integrar juego, visual, progreso offline y APK; **Google se desarrolla y añade al final**, no paraliza el juego ni añade un requisito previo.

## Qué está verificado y qué falta

- **Verificado en los datos:** 300 niveles de 1 a 300, 30 episodios, diez mundos, 2.545 palabras asignadas contando repeticiones entre niveles, diez misterios, longitudes compatibles, unicidad intra-tablero y ausencia de palabras contenidas entre sí.
- **Verificado por simulación independiente:** 300/300 listas normales se pudieron colocar en el tamaño declarado con direcciones del motor, hasta 128 intentos y normalización de trayectorias palindrómicas. La simulación **no reproduce la interfaz misteriosa heredada**; el implementador debe adaptarla para solución fija.
- **Pendiente de ejecución real:** implementar datos en Kotlin/JSON de la app, pruebas de generación/solución 300/300 en HEAD integrado, referencias bíblicas comprobadas frente al texto RV1909, revisión visual única, prueba en teléfono y APK final.

**Conservación:** este archivo es la vista humana; el JSON enlazado es la definición estructurada. Cualquier cambio aprobado debe actualizar ambos y dejar evidencia en A2, sin versiones divergentes.
