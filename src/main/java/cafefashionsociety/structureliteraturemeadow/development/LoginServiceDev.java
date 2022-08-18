package cafefashionsociety.structureliteraturemeadow.development;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.service.ILoginService;

@Service
@Profile("dev")
public class LoginServiceDev implements ILoginService {

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        boolean loginResult = true;
        return loginResult;
    }

}
