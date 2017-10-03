package ComprasOnline.app;

import ComprasOnline.app.interfaces.Publisher;
import ComprasOnline.produtos.Produto;

public class CarrinhoDeCompras extends Publisher {
	private ItemSelecionado[] items = new ItemSelecionado[10];
	
	private boolean updateItem(ItemSelecionado item, String id) {
	   if (item != null && item.isProduct(id)) {
		   item.add(1);
		   generateEvent(item.getProduto());
		   return true;
	   }
	   return false;
	}
	
	public void addItem(String id, Produto produto) {
		int proximoSlot = -1;
		for (int i = 0; i < items.length; i++) {
			if (updateItem(items[i], id)) {
				return;
			} else {
				if (items[i] == null && proximoSlot == -1) {
					proximoSlot = i;
				}
			}
		}
		items[proximoSlot] = new ItemSelecionado(id, produto);
		generateEvent(items[proximoSlot].getProduto());
	}

	public double getTotal() {
		double total = 0.0;
		for (ItemSelecionado item : items) {
			if (item != null) {
				total += item.getValue();
			}
		}		
		return total;
	}

	public String listItems() {
		String result = "Itens no Carrinho:\n";
		for (ItemSelecionado item : items) {
			if (item != null) {
				result += "\t" + item.getProduto().getDescricao() +
						  " [" + item.getQuantidade() + "]" + "\n";
			}
		}
		return result;
	}	
}
