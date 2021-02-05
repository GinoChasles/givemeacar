import React from 'react'


import { useTranslate } from "react-admin";

import {
    ReferenceInput,
    AutocompleteInput,
    required,
} from "react-admin";

export default function Street() {

    const t = useTranslate();

    return <ReferenceInput label={t('word.street')} source="street_id" reference="streets" validate={[
        required(t('error.required'))
    ]}>
        <AutocompleteInput optionText="name" optionValue={"id"} />
    </ReferenceInput>
}
