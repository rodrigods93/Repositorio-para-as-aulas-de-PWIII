package br.com.etechoracio.monitoria;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MonitoriaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoriaServerApplication.class, args);
	}
	
	@Bean
	public ModelMapper getMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		//Só sera mapeado rigorosamente iguais os nomes de outras tabelas.
		return mapper;
	}

}
