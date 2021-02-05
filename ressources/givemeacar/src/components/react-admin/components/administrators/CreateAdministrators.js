import * as React from "react";

import {
  Create,
  SimpleForm,
  useTranslate
} from "react-admin";

import FirstName from '../form/firstName';
import LastName from '../form/lastName';
import Mail from '../form/mail';
import Phone from '../form/phone';
import Password from '../form/password';

const CreateAdministrators = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('word.creation')}>
    <SimpleForm >

      <FirstName />
      <LastName />
      <Mail />
      <Phone />
      <Password />

    </SimpleForm>
  </Create>

}

export default CreateAdministrators
