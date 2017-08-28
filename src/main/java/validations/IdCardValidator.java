package validations;





import com.dzr.common.util.IdcardValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**

 *
 * @packageName:com.sdxd.auth.dubbo.api.validations
 * @CreateDate:2016/11/10
 * @UpdateDate:2016/11/10
 * @Description:
 */
public class IdCardValidator implements ConstraintValidator<IdCardValid, String> {
//    private String idNumber;

    @Override
    public void initialize(IdCardValid cardId) {
//        this.idNumber = idNumber.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        IdcardValidator validator = new IdcardValidator();
        return validator.isValidatedAllIdcard(value);
    }
}
