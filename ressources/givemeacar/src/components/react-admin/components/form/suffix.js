import React from 'react'


import { useTranslate } from "react-admin";

import {
    ReferenceInput,
    AutocompleteInput,
    required,
} from "react-admin";

export default function Suffix() {

    const t = useTranslate();

    return <ReferenceInput label={t('word.suffix')} source="street_suffix_id" reference="street_suffices" validate={[
        required(t('error.required'))
    ]}>
        <AutocompleteInput optionText="name" optionValue={"id"} />
    </ReferenceInput>
}
