package org.example.entities;

import java.io.Serializable;

public record OrderPK(Long client_id, Long product_id) implements Serializable {
}
