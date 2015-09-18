package dungeon.usuario;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EnvioEmail implements EnvioEmailServico{

	@Override
	//@Scheduled(fixedDelay = 5000)
	public void viarEmail() {
		System.out.println("Enviando Email...");
		
	}

}
