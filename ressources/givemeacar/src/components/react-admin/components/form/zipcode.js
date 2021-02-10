import React from 'react'


import { useTranslate } from "react-admin";

import {
    TextInput,
    required,
    minLength,
    maxLength,
} from "react-admin";

export default function Zipcode() {

    const t = useTranslate();

    return <TextInput label={t('word.zipcode')} source="zipcode"

        validate={[
            required(t('error.required')),
            minLength(5),
            maxLength(5),
        ]}

    />
}
