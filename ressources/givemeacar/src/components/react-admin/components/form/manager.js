import React from 'react'


import { useTranslate } from "react-admin";

import {
    ReferenceInput,
    AutocompleteInput,
    required,
} from "react-admin";

export default function Manager() {

    const t = useTranslate();

    return <ReferenceInput label={t('word.manager')} source="manager_id" reference="managers" className="w-100"
        validate={[
        required(t('error.required'))
    ]}>
        <AutocompleteInput optionText="name" optionValue={"id"} className="w-100" />
    </ReferenceInput>
}
