# Fly Swatter Game

Juego de mata moscas hecho en Java para tu examen con Swing.

---

## Como descargar el proyecto desde GitHub

### Paso 1 — Descargar el codigo

1. Entra al repositorio en GitHub (ya estas aqui asi que ignora esto jsjsj).
2. Haz clic en el boton verde que dice **`<> Code`**.
3. Tienes 2 opciones: Clonar el repositorio o descargarlo como ZIP.
3. Selecciona **Download ZIP**.
4. Guarda el archivo ZIP en tu computadora (por ejemplo en el Escritorio).
5. Haz clic derecho sobre el ZIP y selecciona **Extraer todo** (o "Extract All").
6. Para clonar el repositorio, abre una terminal (Que se Git Bash, ahi te descargue Git) y ejecuta `git clone https://github.com/rdelavega/Examen_Multimedia.git`.

---

### Como ejecutar el juego

1. Abre la carpeta `Examen_Multimedia` que se descargo en el paso anterior.
2. Abre IntelliJ IDEA.
3. En la pantalla de inicio haz clic en **Open**.
4. Busca la carpeta que extrajiste en el Paso 1 y seleccionala.
5. Haz clic en **OK** / **Trust Project** si te lo pregunta.
6. En el panel de la izquierda busca el archivo **`BallGame.java`**.
7. Haz doble clic para abrirlo.
8. Haz clic en el triangulo verde ▶ que aparece al lado de `public static void main`.
9. El juego deberia abrirse en una ventana nueva.

---

## Como se juega

- Mueve el raton para mover el mata moscas.
- Haz clic encima de la mosca para golpearla.
- Cada 3 golpes la mosca se mueve mas rapido (lo puedes ver en GamePanel.java con la función increaseSpeed).
- Llega a **10 puntos** para ganar y sale un texto de "You Win" en amarillo, tambien lo puedes ver en GamePanel.java.
- El boton **Restart** reinicia la partida.
