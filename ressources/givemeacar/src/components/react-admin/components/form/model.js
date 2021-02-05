import React from 'react'


import { useTranslate } from "react-admin";

import {
    ReferenceInput,
    AutocompleteInput,
    required,
} from "react-admin";

export default function Model() {

    const t = useTranslate();

    return <ReferenceInput label={t('word.model')} source="model_id" className="w-100" 
        reference="models" validate={[
            required(t('error.required'))
        ]}>
        <AutocompleteInput optionText="fullName" optionValue={"id"} className="w-100" />
    </ReferenceInput>
}
