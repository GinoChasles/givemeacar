import * as React from "react";

import { useTranslate } from "react-admin";

import {
  Create,
  SimpleForm,
  TextInput,
  PasswordInput,
} from "react-admin";


const CreateAdministrators = (props) => {

  const t = useTranslate();

  return <Create {...props}>
    <SimpleForm>
      <TextInput source="firstName" label={t('custom.firstName')} />
      <TextInput source="lastName" label={t('custom.lastName')} />
      <TextInput source="mail" label={t('custom.mail')} />
      <TextInput source="phone" label={t('custom.phone')} />
      <PasswordInput source="password" label={t('custom.password')} />
    </SimpleForm>
  </Create>

}

export default CreateAdministrators
