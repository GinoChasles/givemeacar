import React from 'react'


import { useTranslate } from "react-admin";

import {
    ReferenceInput,
    AutocompleteInput,
    required,
} from "react-admin";

export default function Region() {

    const t = useTranslate();

    return <ReferenceInput label={t('word.region')} source="region_id" reference="regions" validate={[
        required(t('error.required'))
    ]}>
        <AutocompleteInput optionText="name" optionValue={"id"} />
    </ReferenceInput>
}
