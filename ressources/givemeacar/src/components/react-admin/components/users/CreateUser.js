import * as React from "react";
import {
  PasswordInput,
  Create,
  SimpleForm,
  ReferenceInput,
  AutocompleteInput,
  TextInput,
  NumberInput,
  useTranslate,
  SelectArrayInput,
  BooleanInput,
} from "react-admin";

let globalRoles;

const CreateUser = (props) => {

  const t = useTranslate();

  const [roles, setRoles] = React.useState([]);

  React.useEffect(() => {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', 'application/json');

    fetch('http://localhost:8080/api/roles?_start=0&_end=25&_sort=id&order=asc', {
      headers
    }).then(res => {
      if (res.ok) {
        return res.json()
      }
    }).then(json => {
      setRoles(json);
      globalRoles = json;
    })
  }, []);

  return <Create {...props} title={t('custom.creation')} transform={(data) => {
    data.roles = data.roleIds
    data.username = data.mail
    delete data.roleIds

    Object.values(data.roles).forEach((dataRole, i) => {
      Object.values(globalRoles).forEach(role => {
        if (role.id === dataRole) {
          data.roles[i] = role;
        }
      })
    })

    return data;
  }}>

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

      <SelectArrayInput source="roleIds" choices={roles} />

      <BooleanInput source="enabled" />
    </SimpleForm>
  </Create>
}
export default CreateUser;