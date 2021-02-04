import * as React from "react";
import {
  NumberInput,
  Create,
  SimpleForm,
  ReferenceInput,
  AutocompleteInput,
  TextInput,
  useTranslate
} from "react-admin";


const CreateCity = (props) => {

  const t = useTranslate();

  return <Create {...props}>
    <SimpleForm>

      <TextInput label={t('custom.zipcode')} source="zipcode" />

      <TextInput label={t('custom.name')} source="name" />

      <NumberInput label={t('custom.latitude')} source="latitude" />

      <NumberInput label={t('custom.longitude')} source="longitude" />

      <ReferenceInput label={t('custom.department')} source="department_id" reference="departments">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

    </SimpleForm>
  </Create>
}
export default CreateCity
