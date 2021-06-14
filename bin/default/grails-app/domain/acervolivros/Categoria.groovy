package acervolivros

class Categoria {

    String nome

    String toString(){
        this.nome
    }

    static constraints = {
        nome nullable:false, blank:false, unique:true, maxSize:128
    }
}
