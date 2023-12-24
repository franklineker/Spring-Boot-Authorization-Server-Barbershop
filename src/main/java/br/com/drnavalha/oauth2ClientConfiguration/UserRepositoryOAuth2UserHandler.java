package br.com.drnavalha.oauth2ClientConfiguration;

import br.com.drnavalha.domain.User;
import br.com.drnavalha.mapper.UserMapper;
import br.com.drnavalha.repository.UserRepository;
import com.nimbusds.jose.JOSEObjectJSON;
import com.nimbusds.jose.shaded.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.json.JsonObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.function.Consumer;
@AllArgsConstructor
@Slf4j
public class UserRepositoryOAuth2UserHandler implements Consumer<OAuth2User> {

    private final UserRepository userRepository;

    @Override
    public void accept(OAuth2User oAuth2User) {
        String oAuth2UserEmail = oAuth2User.getAttributes().get("email").toString();

        if (!Optional.ofNullable(userRepository.findByEmail(oAuth2UserEmail)).isPresent()) {
            User user = UserMapper.fromOauth2User(oAuth2User);
            log.info(user.toString());
            System.out.println(user);

            createBarbershopClient(oAuth2User);
            this.userRepository.save(user);
        }else {
            log.info("Bem-vindo {}", oAuth2User.getAttributes().get("given_name"));
            System.out.println("Bem-vindo " +  oAuth2User.getAttributes().get("name"));
        }
    }

    public String createBarbershopClient(OAuth2User oAuth2User){
        System.out.println("entrou no create client");
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://34.29.168.109:9000/clients/save";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String name = oAuth2User.getAttribute("name");
        String email = oAuth2User.getAttribute("email");
        String sub = oAuth2User.getName();
        String requestBody = String.format("{\"userType\":\"3\", \"googleSub\": \"%s\", \"image\": null, \"person\": { \"name\": \"%s\", \"phone\": \"\", \"email\": \"%s\", \"address\": \"\"}}", sub, name, email);
        Gson g = new Gson();
        JsonObject json = g.fromJson(requestBody, JsonObject.class);
        System.out.println(requestBody);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);

        String response = responseEntity.getBody();

        return response;
    }

}
