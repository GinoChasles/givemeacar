import * as React from "react";
import {
  PasswordInput,
  Create,
  SimpleForm,
  ReferenceInput,
  AutocompleteInput,
  TextInput,
  NumberInput,
  useTranslate
} from "react-admin";



const CreateUser = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('custom.creation')}>
    <SimpleForm>

      <TextInput label={t('custom.firstName')} source="firstName" />

      <TextInput label={t('custom.lastName')} source="lastName" />

      <TextInput label={t('custom.mail')} source="mail" />

      <PasswordInput label={t('custom.password')} source="password" />

      <TextInput label={t('custom.phone')} source="phone" />

      <NumberInput label={t('custom.number')} source="streetNumber" />

      <ReferenceInput label={t('custom.suffix')} source="street_suffix_id" reference="street_suffices">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

      <ReferenceInput label={t('custom.street')} source="street_id" reference="streets">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

      <ReferenceInput label={t('custom.city')} source="city_id" reference="cities">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

      <ReferenceInput label={t('custom.agency')} source="agency_id" reference="agencies">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

      <ReferenceInput label={t('custom.roles')} source="roles" reference="roles">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

    </SimpleForm>
  </Create>
}
export default CreateUser;