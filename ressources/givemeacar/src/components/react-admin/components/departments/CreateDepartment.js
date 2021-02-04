import * as React from "react";
import {
  Create,
  SimpleForm,
  ReferenceInput,
  AutocompleteInput,
  TextInput,
  useTranslate
} from "react-admin";


const CreateDepartment = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('custom.creation')}>
    <SimpleForm>
      <ReferenceInput label={t('custom.region')} source="region_id" reference="regions">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>
      <TextInput label={t('custom.code')} source="code" />
      <TextInput label={t('custom.name')} source="name" />
    </SimpleForm>
  </Create>
}

export default CreateDepartment
