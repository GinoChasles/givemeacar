import {
    Datagrid, Filter, List, SearchInput, TextField, useTranslate
} from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplaySuffix = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('custom.suffices')} filters={<PostFilter />}>
        <Datagrid rowClick="edit">
            <TextField label={t('custom.id')} source="id" />

            <TextField label={t('custom.name')} source="name" />
        </Datagrid>
    </List>
}

export default DisplaySuffix