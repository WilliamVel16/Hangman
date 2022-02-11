package myProject;

public class ControlHangman {
    private Diccionario frases;
    private String frase, clave, errores;
    private int conteoErrores;
    private boolean fallo, ganar;

    public ControlHangman(){
        frases = new Diccionario();
    }

    public String pintarClaveFrase(){
        //inicializacion de las variables de control de la ronda de juego
        clave = "";
        frase = frases.getFrase();
        errores = "Letras erroneas: ";
        conteoErrores = 0;

        //crear clave
        for(int i=0; i<frase.length(); i++){
            if(frase.charAt(i) == ' '){
                clave += frase.charAt(i);
            }else{
                clave += "-";
            }
        }
        return clave;
    }

    //validar si un caracter digitado está contenido en la frase
    public String validarLetra(char letra){
        fallo = false;
        int index = frase.indexOf(letra); //indexOf encuentra la primera incidencia en la cadena y devuelve su indice
        if(index != -1){
            while(index > -1){
                reemplazarLetra(index,letra);
                index = frase.indexOf(letra,index+1);
            }
        }else{
            fallo = true;
            conteoErrores++;
            errores += letra + " ";
        }
        return clave;
    }

    private void reemplazarLetra(int index, char letra) {
        char[] arrayClave = clave.toCharArray();
        arrayClave[index] = letra;
        clave = String.copyValueOf(arrayClave);
    }

    //determinar si hay ganador
    public boolean isGanador(){
        ganar = (clave.indexOf('-') == -1)?true : false;
        return ganar;
    }

    public String getClave() {
        return clave;
    }

    public String getErrores() {
        return errores;
    }

    public int getConteoErrores() {
        return conteoErrores;
    }

    public boolean isFallo() {
        return fallo;
    }

    public String getFrase() {
        return frase;
    }
}
