package br.com.alura.gerenciador.modelo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	//é executado quando a jvm carrega a class
	static {
		Empresa emp1 = new Empresa("Alura","123");
		emp1.setId(chaveSequencial++);
		
		Empresa emp2 = new Empresa("Google","123");
		emp2.setId(chaveSequencial++);
		
		Banco.empresas.add(emp1);
		Banco.empresas.add(emp2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("matheus");
		u1.setSenha("12345");
		
		Usuario u2 = new Usuario();
		u2.setLogin("raquel");
		u2.setSenha("123456");
		
		Banco.usuarios.add(u1);
		Banco.usuarios.add(u2);
	}

	
	public void adicionar(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		Banco.empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.empresas;
	}
	
	public Empresa getEmpresa(int id) {
		 Optional<Empresa> empresa = Banco.empresas.stream().filter(emp-> emp.getId().compareTo(id) == 0).findFirst();
		 if(empresa.isPresent()) return empresa.get();
		 return null;
	}
	
	public Optional<Usuario> getUsuario(String login, String senha) {
		 Optional<Usuario> usuario = Banco.usuarios.stream().filter(usu -> usu.ehIgual(login, senha)).findFirst();
		 return usuario;
	}
	
	public void remove(Integer id) {
		
//		Banco.empresas.stream()
//		 	.filter(emp -> emp.getId() != null)
//		 	.collect(Collectors.toList())
//		 	.removeIf(emp -> emp.getId().compareTo(id)==0);
		
		
		
		Banco.empresas.removeIf(emp -> emp.getId().compareTo(id)==0);
	}
	
	public void alteraEmpresa(Empresa emp) {
		Empresa empresaAlterar = this.getEmpresa(emp.getId());
		
		if(empresaAlterar!=null) {
			empresaAlterar.setNome(emp.getNome());
			empresaAlterar.setCnpj(emp.getCnpj());
			empresaAlterar.setDataAbertura(emp.getDataAbertura());
		}
	}
	
}
