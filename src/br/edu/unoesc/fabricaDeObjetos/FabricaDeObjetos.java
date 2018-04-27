package br.edu.unoesc.fabricaDeObjetos;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

public class FabricaDeObjetos<T> {

	private final Class<T> classe;

	public FabricaDeObjetos(Class<T> classe) {
		super();
		this.classe = classe;
	}
	
	
	public T criarDo(HttpServletRequest request){
		
		try {
			T objetoRetorno = classe.newInstance();
			Field[] fields = classe.getDeclaredFields();
			
			for (Field field : fields) {
				// pega o valor digitado na tela
				String valor = request.getParameter(field.getName());
				
				// deixo o field acessível
				field.setAccessible(true);
				
				// verifico se o campo possui conversor customizado
				if(field.isAnnotationPresent(Converter.class)){
					// busco a anotação configurada
					Converter c = field.getAnnotation(Converter.class);
					// Crio o conversor a partir da anotação
					ConversorWeb<?> conversor = c.conversor().newInstance();
					// Converto a String usando o conversor
					Object valorConvertido = conversor.converter(valor);
					// atribuo o valor convertido
					field.set(objetoRetorno, valorConvertido);
				} else {
					// atribuição do valor
					field.set(objetoRetorno, valor);
				}
			}
			
			return objetoRetorno;
			
		} catch (InstantiationException | 
				IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
}
