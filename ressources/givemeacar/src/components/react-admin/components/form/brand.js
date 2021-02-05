import React from 'react'


import { useTranslate } from "react-admin";

import {
    ReferenceInput,
    AutocompleteInput,
    required,
} from "react-admin";

export default function Brand() {

    const t = useTranslate();

    return <ReferenceInput label={t('word.brand')} source="brand_id" reference="brands" validate={[
        required(t('error.required'))
    ]}>
        <AutocompleteInput optionText="name" optionValue={"id"} />
    </ReferenceInput>
}
