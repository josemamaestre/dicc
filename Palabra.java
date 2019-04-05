package es.iesmaestredecalatrava.diccionario;

import java.util.Arrays;

/**
 * Clase que permite crear objetos Palabra
 * <p>
 * Un objeto Palabra representa una palabra incluida en un diccionario, 
 * que albergará su traducción a varios idiomas
 * </p>
 *  
 * @author josema
 * @version 1.1
 * 
 */
public class Palabra implements java.io.Serializable {

    /**
     * Serial version UID generated 
     */
    private static final long serialVersionUID = -5452937402139527024L;

    /**
     * Constante: numero de idiomas disponibles
     */
    public final static int NUMBER_OF_LANGS = 3;

    /**
     * Constante: posicion en el array de la palabra en español.
     */
    public final static int ES = 0;

    /**
     * Constante: posicion en el array de la palabra en inglés.
     */
    public final static int EN = 1;
	
    /**
     * Constante: posicion en el array de la palabra en francés.
     */
    public final static int FR = 2;

    /**
     * Array con las traducciones de la palabra.
     */
    private String word[];

    /**
     * Constructor simple.
     * 
     * @param es palabra en español
     * @param en palabra en inglés
     */
    public Palabra(String es, String en){
        this(es, en, "?");
    }

    /**
     * Construtor completo.
     * 
     * @param es palabra en español
     * @param en palabra en inglés
     * @param fr palabra en francés
     */
    public Palabra(String es, String en, String fr){
        // Creo el array con las traducciones
        this.word = new String[NUMBER_OF_LANGS];

        // Guardo las traducciones
        this.word[ES] = new String(es);
        this.word[EN] = new String(en);
        this.word[FR] = new String(fr);
    }

    /**
     * Indica si el objeto Palabra actual es igual que otro pasado.
     * @return true si la palabra en español coincide; false en otro caso. 
     */
    @Override
    public boolean equals(Object obj) {
        boolean ret = false;

        if (obj != null && obj instanceof Palabra){
            Palabra p = (Palabra)obj;
            String w[] = p.getWord();
            // Comparo solo la palabra en español
            ret = this.word[ES].equals(w[ES]); 
        }

        return ret;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Arrays.deepHashCode(this.word);
        return hash;
    }

    /**
     * Getter para atributo word (array con las traducciones).
     * 
     * @return the word
     */
    public String[] getWord() {
        return word;
    }

    /**
     * Setter para alguna traducción de la palabra. 
     * <p>
     * NO se puede modificar el texto en español.
     * </p>
     * 
     * @param nuevoTexto la palabra en francés
     * @param idioma código del idioma. Utiliza las constantes.
     */
    public void setWord(String nuevoTexto, int idioma) {
        if (idioma != Palabra.ES){
            word[idioma] = nuevoTexto;
        }
    }

    /**
     * Devuelve una cadena representativa de la Palabra.
     * 
     * @return cadena con las traducciones disponibles de la palabra. 
     */
    @Override
    public String toString() {
        return "Palabra " + Arrays.toString(word);
    }

}
