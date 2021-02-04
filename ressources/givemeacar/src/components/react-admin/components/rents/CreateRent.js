import * as React from "react";
import {
  DateTimeInput,
  Create,
  SimpleForm,
  required,
  useTranslate
} from "react-admin";

import Client from '../form/client';
import Car from '../form/car';

const CreateRent = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('word.creation')}>
    <SimpleForm>

      <DateTimeInput label={t('word.rentStart')} source="start" validate={[
        required()
      ]} />

      <DateTimeInput label={t('word.rentEnd')} source="end" validate={[
        required()
      ]} />

      <Car />

      <Client />

    </SimpleForm>
  </Create>
}
export default CreateRent