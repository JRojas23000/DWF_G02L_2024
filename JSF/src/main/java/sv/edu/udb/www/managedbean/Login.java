package sv.edu.udb.www.managedbean;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.ManagedProperty;
import sv.edu.udb.www.util.JsfUtil;
import java.util.ResourceBundle;

@ManagedBean
@RequestScoped

public class Login {
    @ManagedProperty("#{language}")
    private Language idioma;

    public Language getIdioma(){
        return idioma;
    }

    public void setIdioma(Language idioma){
        this.idioma = idioma;
    }

    private String usuario;
    private String password;

    public Login(){
        }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getUsuario(){
        return usuario;
    }
    public String validar(){
        if(getUsuario().equals("Rafael") && getPassword().equals("Torres")){
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle",idioma.getLocale()).getString("LoginCorrecto"));
            return "bienvenido";
        }else{
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle",idioma.getLocale()).getString("LoginError"));
            return null;
        }
    }
}
