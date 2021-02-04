import * as React from "react";
import {
  Create,
  SimpleForm,
  TextInput,
  useTranslate
} from "react-admin";


const CreateCountry = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('custom.creation')}>
    <SimpleForm>
      <TextInput label={t('custom.name')} source="name" />
    </SimpleForm>
  </Create>

}
export default CreateCountry