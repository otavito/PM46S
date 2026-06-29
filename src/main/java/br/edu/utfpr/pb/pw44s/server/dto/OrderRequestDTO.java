package br.edu.utfpr.pb.pw44s.server.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {

    @NotEmpty(message = "A lista de itens do pedido não pode estar vazia")
    private List<OrderItemDTO> items;

    public OrderRequestDTO() {
    }

    public OrderRequestDTO(List<OrderItemDTO> items) {
        this.items = items;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
