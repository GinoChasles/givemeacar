import * as React from "react";
import {
  Create,
  SimpleForm,
  ReferenceInput,
  AutocompleteInput,
  TextInput,
  useTranslate
} from "react-admin";


const CreateModel = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('custom.creation')}>
    <SimpleForm>
      <ReferenceInput label={t('custom.brand')} source="brand_id" reference="brands" >
        <AutocompleteInput optionText={"name"} optionValue={"id"} />
      </ReferenceInput>

      <TextInput label={t('custom.name')} source="name" />
    </SimpleForm>
  </Create>
}
export default CreateModel