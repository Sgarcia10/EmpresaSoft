package mundo;

public class PersistenciaException extends Exception
{

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * M�todo que construye la excepci�n.
     * @param mensaje Mensaje que desea incluirse como detalle de la excepci�n.
     */
    public PersistenciaException( String mensaje )
    {
        super( "Ocurri� el siguiente error: \n" + mensaje );
    }

}
