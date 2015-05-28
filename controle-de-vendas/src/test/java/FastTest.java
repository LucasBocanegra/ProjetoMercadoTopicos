import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import br.com.starcode.logic.Produto;
import br.com.starcode.logic.RegistroVenda;
// classe de teste rápido, criada para fazer pequenos teste rápidos, sem adotar nenhum critério
//TODO excluir esta classe quando for criar os casos de teste efetivos
public class FastTest {

	@Test //(expected = RuntimeException.class)
	public void testDataReg() {
		ArrayList<Produto> p =  new ArrayList<Produto>();
		p.add(new Produto(1," descricao",5.0, 7.0,"un",10.0,1));
		p.add(new Produto(2," descricao 2",5.0, 7.0,"un",20.0,1));
		p.add(new Produto(3," descricao 3",5.0, 7.0,"un",30.0,1));
		
		ArrayList<Double> q = new ArrayList<Double>();
		q.add(5.0);
		q.add(3.0);
		q.add(6.0);
		
		RegistroVenda reg = new RegistroVenda();
		reg.setQuantidadeItens(3);
		reg.setQuantidades(q);
		reg.setProdutos(p);
		for (Produto prod : p) {
			System.out.println(prod.getEstoque());
		}
		
		if(p.get(0).getEstoque() == 5.0 && p.get(1).getEstoque() == 17.0 && p.get(2).getEstoque() == 24.0)
			assert(true);
		else
			assert(false);		
	}
}
