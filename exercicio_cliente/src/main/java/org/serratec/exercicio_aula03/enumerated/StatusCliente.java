package org.serratec.exercicio_aula03.enumerated;

public enum StatusCliente {
    ATIVO(1, "Ativo"),
    INATIVO(2, "Inativo"),
    BLOQUEADO(3, "Bloqueado");

    private Integer codigo;
    private String tipo;

    StatusCliente(Integer codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
