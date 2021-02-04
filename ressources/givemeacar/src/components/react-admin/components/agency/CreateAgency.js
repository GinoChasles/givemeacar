import * as React from "react";
import {
  Create,
  SimpleForm,
  ReferenceInput,
  AutocompleteInput,
  TextInput,
  NumberInput,
  useTranslate
} from "react-admin";


const CreateAgency = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('custom.creation')}>
    <SimpleForm>
      <TextInput label={t('custom.name')} source="name" />

      <NumberInput label={t('custom.streetNumber')} source="streetNumber" />

      <ReferenceInput label={t('custom.suffix')} source="street_suffix_id" reference="street_suffices">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

      <ReferenceInput label={t('custom.street')} source="street_id" reference="streets">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

      <ReferenceInput label={t('custom.city')} source="city_id" reference="cities">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

    </SimpleForm>
  </Create>
}

export default CreateAgency
