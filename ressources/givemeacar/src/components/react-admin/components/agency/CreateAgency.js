import * as React from "react";

import {
  Create,
  SimpleForm,
  useTranslate
} from "react-admin";

import City from '../form/city';
import Street from '../form/street';
import Suffix from '../form/suffix';
import Name from '../form/name';
import StreetNumber from '../form/streetNumber';

const CreateAgency = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('word.creation')}>
    <SimpleForm>
      
      <Name />
      <StreetNumber />
      <Suffix />
      <Street />
      <City />

    </SimpleForm>
  </Create>
}

export default CreateAgency
