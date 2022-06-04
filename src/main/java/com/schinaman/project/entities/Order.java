package com.schinaman.project.entities;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name = "TB_ORDER")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Order implements Serializable {
	private static final long serialVersionUID = 7860581297555175651L;
	
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
		@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date instante;
		@OneToOne (cascade=CascadeType.ALL, mappedBy = "order") //como é o mesmo id cascade all trata trata a transiencia da informação por nao estar salva no bd
	private Payment payment;
		@ManyToOne
		@JoinColumn(name = "client_id")
	private Client client;
		@ManyToOne
		@JoinColumn(name = "addressDelivery_id")
	private Address addressDelivery;
		
		@Setter(AccessLevel.NONE)
		@OneToMany (mappedBy = "id.order") 
	private Set<ItemOrder> items = new HashSet<>();
	

	public Order(Integer id, Date instante,  Client client, Address addressDelivery) { //Payment payment para poder instanciar pedido primeiro
		super();
		this.id = id;
		this.instante = instante;
		this.client = client;
		this.addressDelivery = addressDelivery;
	}
	
	public double getValorTotal() {
		double soma = 0.0;
		for (ItemOrder ip : items) {
			soma = soma + ip.getSubTotal();
		}
		return soma;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido número: ");
		builder.append(getId());
		builder.append(", Instante: ");
		builder.append(sdf.format(getInstante()));
		builder.append(", Cliente: " );
		builder.append(getClient().getName());
		builder.append(", Situação do pagamento: ");
		builder.append(getPayment().getPaymentState().getDescription());
		builder.append("\nDetalhes:\n");
		for (ItemOrder io : getItems()) {
			builder.append(io.toString());
		}
		builder.append("Valor total: ");
		builder.append(nf.format(getValorTotal()));
		return builder.toString();
	}
	
	
}
