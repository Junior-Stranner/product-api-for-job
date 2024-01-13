package br.com.nunes.sports.products.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "produtos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String descricao;

    @Digits(integer = 10, fraction = 2)
    @DecimalMin(value = "0.00", inclusive = false)
    @DecimalMax(value = "9999999.00")
    @Column(name = "preco", precision = 10, scale = 2,nullable = false) // Precision e scale ajustados conforme necessário
    private BigDecimal preco;
    
    
}
