package util;


public enum Partido {
    PMDB	("PARTIDO DO MOVIMENTO DEMOCRÁTICO BRASILEIRO"),
    PTB	    ("PARTIDO TRABALHISTA BRASILEIRO"),
    PDT	    ("PARTIDO DEMOCRÁTICO TRABALHISTA"),
    PT	    ("PARTIDO DOS TRABALHADORES"),
    DEM	    ("DEMOCRATAS"),
    PCdoB	("PARTIDO COMUNISTA DO BRASIL"),
    PSB	    ("PARTIDO SOCIALISTA BRASILEIRO"),
    PSDB	("PARTIDO DA SOCIAL DEMOCRACIA BRASILEIRA"),
    PTC	    ("PARTIDO TRABALHISTA CRISTÃO"),
    PSC	    ("PARTIDO SOCIAL CRISTÃO"),
    PMN 	("PARTIDO DA MOBILIZAÇÃO NACIONAL"),
    PRP	    ("PARTIDO REPUBLICANO PROGRESSISTA"),
    PPS	    ("PARTIDO POPULAR SOCIALISTA"),
    PV	    ("PARTIDO VERDE"),
    PTdoB	("PARTIDO TRABALHISTA DO BRASIL"),
    PP	    ("PARTIDO PROGRESSISTA"),
    PSTU	("PARTIDO SOCIALISTA DOS TRABALHADORES UNIFICADO"),
    PCB	    ("PARTIDO COMUNISTA BRASILEIRO"),
    PRTB	("PARTIDO RENOVADOR TRABALHISTA BRASILEIRO"),
    PHS	    ("PARTIDO HUMANISTA DA SOLIDARIEDADE"),
    PSDC	("PARTIDO SOCIAL DEMOCRATA CRISTÃO"),
    PCO	    ("PARTIDO DA CAUSA OPERÁRIA"),
    PTN	    ("PARTIDO TRABALHISTA NACIONAL"),
    PSL	    ("PARTIDO SOCIAL LIBERAL"),
    PRB	    ("PARTIDO REPUBLICANO BRASILEIRO"),
    PSOL	("PARTIDO SOCIALISMO E LIBERDADE"),
    PR	    ("PARTIDO DA REPÚBLICA"),
    PSD	    ("PARTIDO SOCIAL DEMOCRÁTICO"),
    PPL	    ("PARTIDO PÁTRIA LIVRE"),
    PEN	    ("PARTIDO ECOLÓGICO NACIONAL"),
    PROS	("PARTIDO REPUBLICANO DA ORDEM SOCIAL"),
    SD      ("SOLIDARIEDADE"),
    NOVO	("PARTIDO NOVO"),
    REDE	("REDE SUSTENTABILIDADE"),
    PMB	    ("PARTIDO DA MULHER BRASILEIRA");

    private final String nome;

    Partido(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }
}