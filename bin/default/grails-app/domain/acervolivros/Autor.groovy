package acervolivros

class Autor {

    String nome
    String bibliografia
    byte[] fotoByte
    String fotoString

    static constraints = {
        nome nullable:false, blank:false, maxSize:128, unique:true
        bibliografia nullable:true, blank:true
        fotoByte nullable:true, blank:true, maxSize: 25 * 1024 * 1024
        fotoString nullable:true
    }

     String toString(){
        this.nome
    }

    static mapping = {
        fotoByte column: 'foto_byte', sqlType: 'longblob'
        fotoString column: 'foto_string'
    }
}
