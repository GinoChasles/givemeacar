import * as React from "react";
import {
  Create,
  SimpleForm,
  useTranslate
} from "react-admin";


import Name from '../form/name';
import Code from '../form/code';
import Region from '../form/region';

const CreateDepartment = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('word.creation')}>
    <SimpleForm>

      <Region />

      <Code />

      <Name />

    </SimpleForm>
  </Create>
}

export default CreateDepartment
