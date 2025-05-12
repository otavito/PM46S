package br.edu.utfpr.pb.pw44s.server.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class OrderItemDTO {

    private Long id;

    @NotNull
    private Long orderId;

    @NotNull
    private Long productId;

    @NotNull
    @Min(value = 1, message = "Quantidade mínima: 1")
    private Integer quantidade;

    @NotNull
    private BigDecimal preco;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Long id, Long orderId, Long productId, Integer quantidade, BigDecimal preco) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
