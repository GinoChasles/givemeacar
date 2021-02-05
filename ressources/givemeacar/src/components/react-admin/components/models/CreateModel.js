import * as React from "react";
import {
  Create,
  SimpleForm,
  useTranslate
} from "react-admin";

import Name from '../form/name';
import Brand from '../form/brand';

const CreateModel = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('word.creation')}>
    <SimpleForm>

      <Brand />

      <Name />

    </SimpleForm>
  </Create>
}
export default CreateModel