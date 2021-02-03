import * as React from "react";
import {
  Create,
  SimpleForm,
  TextInput,
  useTranslate
} from "react-admin";


const CreateBrand = (props) => {

  const t = useTranslate()

  return <Create {...props}>
    <SimpleForm>
      <TextInput label={t('custom.name')} source="name" />
    </SimpleForm>
  </Create>
}

export default CreateBrand
