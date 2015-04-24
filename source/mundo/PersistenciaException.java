package mundo;

public class PersistenciaException extends Exception
{

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Método que construye la excepción.
     * @param mensaje Mensaje que desea incluirse como detalle de la excepción.
     */
    public PersistenciaException( String mensaje )
    {
        super( "Ocurrió el siguiente error: \n" + mensaje );
    }

}
