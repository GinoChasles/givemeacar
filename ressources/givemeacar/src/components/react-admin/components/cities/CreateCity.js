import * as React from "react";
import {
  Create,
  SimpleForm,
  ReferenceInput,
  AutocompleteInput,
  TextInput,
  useTranslate
} from "react-admin";

import Name from '../form/name'
import Latitude from '../form/latitude'
import Longitude from '../form/longitude'
import Department from '../form/department'
import Zipcode from '../form/zipcode'

const CreateCity = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('word.creation')}>
    <SimpleForm>

      <Zipcode />

      <Name />

      <Latitude />

      <Longitude />

      <Department />

    </SimpleForm>
  </Create>
}
export default CreateCity
