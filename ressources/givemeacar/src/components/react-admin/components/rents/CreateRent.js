import * as React from "react";
import {
  DateTimeInput,
  Create,
  SimpleForm,
  ReferenceInput,
  AutocompleteInput,
  useTranslate
} from "react-admin";


const CreateRent = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('custom.creation')}>
    <SimpleForm>

      <DateTimeInput label={t('custom.rentStart')} source="start" />

      <DateTimeInput label={t('custom.rentEnd')} source="end" />

      <ReferenceInput label={t('custom.car')} source="car_id" reference="cars">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

      <ReferenceInput label={t('custom.client')} source="client_id" reference="clients">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>
    </SimpleForm>
  </Create>
}
export default CreateRent