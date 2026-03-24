    package com.sena.tienda.entity;

    import jakarta.persistence.*;

    @Entity
    public class Inventario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private int stock;

        @OneToOne
        private Bicicleta bicicleta;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public Bicicleta getBicicleta() {
            return bicicleta;
        }

        public void setBicicleta(Bicicleta bicicleta) {
            this.bicicleta = bicicleta;
        }
    }