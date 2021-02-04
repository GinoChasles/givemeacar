import * as React from "react";
import {
  Create,
  SimpleForm,
  useTranslate
} from "react-admin";

import Name from '../form/name';

const CreateEnergyType = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('word.creation')}>
    <SimpleForm>
      <Name />
    </SimpleForm>
  </Create>
}
export default CreateEnergyType