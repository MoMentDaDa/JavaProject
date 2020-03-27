package Anno.Value;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class port {
	@Value("${server.port}")
	int port;
}
